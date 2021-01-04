package org.denamyte.hyperskill.tasks;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://hyperskill.org/learn/step/5704">Edit distance alignment in Java -> Multiple sequence alignment</a>
 */
public class EditDistanceAlignmentInJava_MultipleSequenceAlignment {

    static final int DOUBLE_GAP_COST = 4;

    public static int pairMatch(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static Alignment3 editDistanceAlignment(String s, String t, String u) {

        CellData[][][] cubeSD = new CellData[s.length() + 1][t.length() + 1][u.length() + 1];

        cubeSD[0][0][0] = new CellData(0, 0);

        // Initializing cube edges
        for (int i = 1; i < s.length() + 1; i++) {
            int cost = i * DOUBLE_GAP_COST;
            cubeSD[i][0][0] = new CellData(cost, cost - cubeSD[i - 1][0][0].cost);
        }
        for (int j = 1; j < t.length() + 1; j++) {
            int cost = j * DOUBLE_GAP_COST;
            cubeSD[0][j][0] = new CellData(cost, cost - cubeSD[0][j - 1][0].cost);
        }
        for (int k = 1; k < u.length() + 1; k++) {
            int cost = k * DOUBLE_GAP_COST;
            cubeSD[0][0][k] = new CellData(cost, cost - cubeSD[0][0][k - 1].cost);
        }

        // Initialization cube surfaces
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                int replaceCost = pairMatch(s.charAt(i - 1), t.charAt(j - 1)) + DOUBLE_GAP_COST;
                CellData insCostCD = new CellData(cubeSD[i][j - 1][0].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST);
                CellData delCostCD = new CellData(cubeSD[i - 1][j][0].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST);
                CellData subCostCD = new CellData(cubeSD[i - 1][j - 1][0].cost + replaceCost, replaceCost);
                CellData minData = Stream.of(insCostCD, delCostCD, subCostCD).min(cellDataComparator).orElseThrow();
                cubeSD[i][j][0] = minData;
            }
        }
        for (int j = 1; j < t.length() + 1; j++) {
            for (int k = 1; k < u.length() + 1; k++) {
                int replaceCost = pairMatch(t.charAt(j - 1), u.charAt(k - 1)) + DOUBLE_GAP_COST;
                CellData insCostCD = new CellData(cubeSD[0][j][k - 1].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST);
                CellData delCostCD = new CellData(cubeSD[0][j - 1][k].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST);
                CellData subCostCD = new CellData(cubeSD[0][j - 1][k - 1].cost + replaceCost, replaceCost);
                CellData minData = Stream.of(insCostCD, delCostCD, subCostCD).min(cellDataComparator).orElseThrow();
                cubeSD[0][j][k] = minData;
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int k = 1; k < u.length() + 1; k++) {
                int replaceCost = pairMatch(s.charAt(i - 1), u.charAt(k - 1)) + DOUBLE_GAP_COST;
                CellData insCostCD = new CellData(cubeSD[i][0][k - 1].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST);
                CellData delCostCD = new CellData(cubeSD[i - 1][0][k].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST);
                CellData subCostCD = new CellData(cubeSD[i - 1][0][k - 1].cost + replaceCost, replaceCost);
                CellData minData = Stream.of(insCostCD, delCostCD, subCostCD).min(cellDataComparator).orElseThrow();
                cubeSD[i][0][k] = minData;
            }
        }

        // Filling up the cube
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                for (int k = 1; k <= u.length(); k++) {

                    char s1Char = s.charAt(i - 1);
                    char s2Char = t.charAt(j - 1);
                    char s3Char = u.charAt(k - 1);
                    int costPairIJ = pairMatch(s1Char, s2Char);
                    int costPairIK = pairMatch(s1Char, s3Char);
                    int costPairJK = pairMatch(s2Char, s3Char);

                    CellData minData = Stream.of(
                            new CellData(cubeSD[i - 1][j - 1][k - 1].cost + costPairIJ + costPairIK + costPairJK, costPairIJ + costPairIK + costPairJK),
                            new CellData(cubeSD[i - 1][j - 1][k    ].cost + costPairIJ + DOUBLE_GAP_COST, costPairIJ + DOUBLE_GAP_COST),
                            new CellData(cubeSD[i - 1][j    ][k - 1].cost + costPairIK + DOUBLE_GAP_COST, costPairIK + DOUBLE_GAP_COST),
                            new CellData(cubeSD[i    ][j - 1][k - 1].cost + costPairJK + DOUBLE_GAP_COST, costPairJK + DOUBLE_GAP_COST),
                            new CellData(cubeSD[i - 1][j    ][k    ].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST),
                            new CellData(cubeSD[i    ][j - 1][k    ].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST),
                            new CellData(cubeSD[i    ][j    ][k - 1].cost + DOUBLE_GAP_COST, DOUBLE_GAP_COST)
                    ).min(cellDataComparator).orElseThrow();
                    cubeSD[i][j][k] = minData;
                }
            }
        }
        return reconstructAlignment(cubeSD, s, t, u);
    }

    public static Alignment3 reconstructAlignment(CellData[][][] cubeSD, String s, String t, String u) {
        StringBuilder ssBuilder = new StringBuilder();
        StringBuilder ttBuilder = new StringBuilder();
        StringBuilder uuBuilder = new StringBuilder();
        int i = s.length();
        int j = t.length();
        int k = u.length();

        int editDistance = cubeSD[i][j][k].cost;

        while (i > 0 || j > 0 || k > 0) {
            CellData data = cubeSD[i][j][k];
            int prevCost = data.cost - data.transCost;
            if (i > 0 && j > 0 && k > 0 &&
                    prevCost == cubeSD[i - 1][j - 1][k - 1].cost) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append(t.charAt(j - 1));
                uuBuilder.append(u.charAt(k - 1));
                i--;
                j--;
                k--;
            } else if (i > 0 && j > 0 &&
                    prevCost == cubeSD[i - 1][j - 1][k].cost) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append(t.charAt(j - 1));
                uuBuilder.append('-');
                i--;
                j--;
            } else if (i > 0 && k > 0 &&
                    prevCost == cubeSD[i - 1][j][k - 1].cost) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append('-');
                uuBuilder.append(u.charAt(k - 1));
                i--;
                k--;
            } else if (j > 0 && k > 0 &&
                    prevCost == cubeSD[i][j - 1][k - 1].cost) {
                ssBuilder.append('-');
                ttBuilder.append(t.charAt(j - 1));
                uuBuilder.append(u.charAt(k - 1));
                j--;
                k--;
            } else if (i > 0 &&
                    prevCost == cubeSD[i - 1][j][k].cost) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append('-');
                uuBuilder.append('-');
                i--;
            } else if (j > 0 &&
                    prevCost == cubeSD[i][j - 1][k].cost) {
                ssBuilder.append('-');
                ttBuilder.append(t.charAt(j - 1));
                uuBuilder.append('-');
                j--;
            } else if (k > 0 &&
                    prevCost == cubeSD[i][j][k - 1].cost) {
                ssBuilder.append('-');
                ttBuilder.append('-');
                uuBuilder.append(u.charAt(k - 1));
                k--;
            }
        }

        String ss = ssBuilder.reverse().toString();
        String tt = ttBuilder.reverse().toString();
        String uu = uuBuilder.reverse().toString();

        return new Alignment3(editDistance, ss, tt, uu);
    }

    static class Alignment3 {
        public int editDistance;
        public String s1;
        public String s2;
        public String s3;

        public Alignment3(int editDistance, String s1, String s2, String s3) {
            this.editDistance = editDistance;
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        @Override
        public String toString() {
            return String.format("%d%n%s%n%s%n%s", editDistance, s1, s2, s3);
        }
    }

    static class CellData {
        int cost;       // The total value;
        int transCost;  // The value of transition;

        public int getCost() {
            return cost;
        }

        public CellData(int cost, int transCost) {
            this.cost = cost;
            this.transCost = transCost;
        }

        @Override
        public String toString() {
            return "cost=" + cost + ", transCost=" + transCost;
        }
    }

    static Comparator<CellData> cellDataComparator = Comparator.comparing(CellData::getCost);

    public static void main(String[] args) {
        List<String> list = new Scanner(System.in).tokens().limit(3).collect(Collectors.toList());
        Alignment3 alignment = editDistanceAlignment(list.get(0), list.get(1), list.get(2));
        System.out.println(alignment);
    }
}
