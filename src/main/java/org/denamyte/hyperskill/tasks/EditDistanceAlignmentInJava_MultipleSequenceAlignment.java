package org.denamyte.hyperskill.tasks;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://hyperskill.org/learn/step/5704">Edit distance alignment in Java -> Multiple sequence alignment</a>
 */
public class EditDistanceAlignmentInJava_MultipleSequenceAlignment {

    static final int DOUBLE_GAP_COST = 4;

    public static int pairMatch(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static Alignment3 editDistanceAlignment(String s, String t, String u) {

        int[][][] cube = new int[s.length() + 1][t.length() + 1][u.length() + 1];

        cube[0][0][0] = 0;
        AlgorithmData data = new AlgorithmData(cube, s, t, u);

        // Initializing the cube edges
        for (int i = 1; i < s.length() + 1; i++) {
            cube[i][0][0] = i * DOUBLE_GAP_COST;
        }
        for (int j = 1; j < t.length() + 1; j++) {
            cube[0][j][0] = j * DOUBLE_GAP_COST;
        }
        for (int k = 1; k < u.length() + 1; k++) {
            cube[0][0][k] = k * DOUBLE_GAP_COST;
        }

        // Initializing the cube surfaces
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                int insCost = cube[i][j - 1][0] + DOUBLE_GAP_COST;
                int delCost = cube[i - 1][j][0] + DOUBLE_GAP_COST;
                int subCost = cube[i - 1][j - 1][0] + pairMatch(s.charAt(i - 1), t.charAt(j - 1)) + DOUBLE_GAP_COST;
                cube[i][j][0] = IntStream.of(insCost, delCost, subCost).min().orElseThrow();
            }
        }
        for (int j = 1; j < t.length() + 1; j++) {
            for (int k = 1; k < u.length() + 1; k++) {
                int insCost = cube[0][j][k - 1] + DOUBLE_GAP_COST;
                int delCost = cube[0][j - 1][k] + DOUBLE_GAP_COST;
                int subCost = cube[0][j - 1][k - 1] + pairMatch(t.charAt(j - 1), u.charAt(k - 1)) + DOUBLE_GAP_COST;
                cube[0][j][k] = IntStream.of(insCost, delCost, subCost).min().orElseThrow();
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int k = 1; k < u.length() + 1; k++) {
                int insCost = cube[i][0][k - 1] + DOUBLE_GAP_COST;
                int delCost = cube[i - 1][0][k] + DOUBLE_GAP_COST;
                int subCost = cube[i - 1][0][k - 1] + pairMatch(s.charAt(i - 1), u.charAt(k - 1)) + DOUBLE_GAP_COST;
                cube[i][0][k] = IntStream.of(insCost, delCost, subCost).min().orElseThrow();
            }
        }

        // Filling up the cube
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                for (int k = 1; k <= u.length(); k++) {
                    cube[i][j][k] = new CellsTransitionCost(data, i, j, k).minTransCost();
                }
            }
        }
        return reconstructAlignment(data, s, t, u);
    }

    public static Alignment3 reconstructAlignment(AlgorithmData cellsData, String s, String t, String u) {
        StringBuilder ssBuilder = new StringBuilder();
        StringBuilder ttBuilder = new StringBuilder();
        StringBuilder uuBuilder = new StringBuilder();
        int i = s.length();
        int j = t.length();
        int k = u.length();

        int editDistance = cellsData.cube[i][j][k];

        while (i > 0 || j > 0 || k > 0) {
            CellsTransitionCost transCost = new CellsTransitionCost(cellsData, i, j, k);
            int curCost = cellsData.cube[i][j][k];
            if (i > 0 && j > 0 && k > 0 && curCost == transCost.transCostIJK()) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append(t.charAt(j - 1));
                uuBuilder.append(u.charAt(k - 1));
                i--;
                j--;
                k--;
            } else if (i > 0 && j > 0 && curCost == transCost.transCostIJX()) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append(t.charAt(j - 1));
                uuBuilder.append('-');
                i--;
                j--;
            } else if (i > 0 && k > 0 && curCost == transCost.transCostIXK()) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append('-');
                uuBuilder.append(u.charAt(k - 1));
                i--;
                k--;
            } else if (j > 0 && k > 0 && curCost == transCost.transCostXJK()) {
                ssBuilder.append('-');
                ttBuilder.append(t.charAt(j - 1));
                uuBuilder.append(u.charAt(k - 1));
                j--;
                k--;
            } else if (i > 0 && curCost == transCost.transCostIXX()) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append('-');
                uuBuilder.append('-');
                i--;
            } else if (j > 0 && curCost == transCost.transCostXJX()) {
                ssBuilder.append('-');
                ttBuilder.append(t.charAt(j - 1));
                uuBuilder.append('-');
                j--;
            } else if (k > 0 && curCost == transCost.transCostXXK()) {  // Should be just 'else' here
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

    static class AlgorithmData {
        final int[][][] cube;
        final String s;
        final String t;
        final String u;

        AlgorithmData(int[][][] cube, String s, String t, String u) {
            this.cube = cube;
            this.s = s;
            this.t = t;
            this.u = u;
        }
    }

    static class CellsTransitionCost {
        final AlgorithmData data;
        final int i;
        final int j;
        final int k;

        public CellsTransitionCost(AlgorithmData data, int i, int j, int k) {
            this.data = data;
            this.i = i;
            this.j = j;
            this.k = k;
        }

        int ijPairCost() {
            return pairMatch(data.s.charAt(i - 1), data.t.charAt(j - 1));
        }

        int ikPairCost() {
            return pairMatch(data.s.charAt(i - 1), data.u.charAt(k - 1));
        }

        int jkPairCost() {
            return pairMatch(data.t.charAt(j - 1), data.u.charAt(k - 1));
        }

        int transCostIJK() {
            return data.cube[i - 1][j - 1][k - 1] + ijPairCost() + ikPairCost() + jkPairCost();
        }

        int transCostIJX() {
            return data.cube[i - 1][j - 1][k] + ijPairCost() + DOUBLE_GAP_COST;
        }

        int transCostIXK() {
            return data.cube[i - 1][j][k - 1] + ikPairCost() + DOUBLE_GAP_COST;
        }

        int transCostXJK() {
            return data.cube[i][j - 1][k - 1] + jkPairCost() + DOUBLE_GAP_COST;
        }

        int transCostIXX() {
            return data.cube[i - 1][j][k] + DOUBLE_GAP_COST;
        }

        int transCostXJX() {
            return data.cube[i][j - 1][k] + DOUBLE_GAP_COST;
        }

        int transCostXXK() {
            return data.cube[i][j][k - 1] + DOUBLE_GAP_COST;
        }

        int minTransCost() {
            return IntStream.of(
                    transCostIJK(),
                    transCostIJX(),
                    transCostIXK(),
                    transCostXJK(),
                    transCostIXX(),
                    transCostXJX(),
                    transCostXXK()
            ).min().orElseThrow();
        }
    }

    static class Alignment3 {
        public int editDistance;
        public String s;
        public String t;
        public String u;

        public Alignment3(int editDistance, String s, String t, String u) {
            this.editDistance = editDistance;
            this.s = s;
            this.t = t;
            this.u = u;
        }

        @Override
        public String toString() {
            return String.format("%d%n%s%n%s%n%s", editDistance, s, t, u);
        }
    }

    public static void main(String[] args) {
        List<String> list = new Scanner(System.in).tokens().limit(3).collect(Collectors.toList());
        Alignment3 alignment = editDistanceAlignment(list.get(0), list.get(1), list.get(2));
        System.out.println(alignment);
    }
}

/*

Test #1

ACGGGT
ACACCGGT
ACCGG

Test #2

TACTTGGCGA
CACATTTGGAATCTG
GTCTCAACGACTAATTAAGT

 */
