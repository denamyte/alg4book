package org.denamyte.hyperskill.tasks;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * <a href="https://hyperskill.org/learn/step/5704">Edit distance alignment in Java -> Multiple sequence alignment</a>
 */
public class EditDistanceAlignmentInJava_MultipleSequenceAlignment {

    static final int GAP_COST = 2;

    public static int pairMatch(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static Alignment3 editDistanceAlignment(String s1, String s2, String s3) {

        // TODO: 1/1/21 The type of the cube array should be MinDistData
        int[][][] cube = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++) {
            cube[i][0][0] = i * 2;
        }
        for (int i = 0; i < s2.length() + 1; i++) {
            cube[0][i][0] = i * 2;
        }
        for (int i = 0; i < s3.length() + 1; i++) {
            cube[0][0][i] = i * 2;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                for (int k = 1; k <= s3.length(); k++) {
                    char s1Char = s1.charAt(i);
                    char s2Char = s2.charAt(i);
                    char s3Char = s3.charAt(i);
                    int costPairIJ = pairMatch(s1Char, s2Char);
                    int costPairIK = pairMatch(s1Char, s3Char);
                    int costPairJK = pairMatch(s2Char, s3Char);

                    // TODO: 1/1/21 Remove the variables below
                    int costIJK = cube[i - 1][j - 1][k - 1] + costPairIJ + costPairIK + costPairJK;
                    int costIJ_ = cube[i - 1][j - 1][k]     + costPairIJ + 2 * GAP_COST;
                    int costI_K = cube[i - 1][j    ][k - 1] + costPairIK + 2 * GAP_COST;
                    int cost_JK = cube[i    ][j - 1][k - 1] + costPairJK + 2 * GAP_COST;
                    int costI__ = cube[i - 1][j    ][k    ] + 2 * GAP_COST;
                    int cost_J_ = cube[i    ][j - 1][k    ] + 2 * GAP_COST;
                    int cost__K = cube[i    ][j    ][k - 1] + 2 * GAP_COST;

                    // TODO: 1/1/21 User this value (or its interpretation) to save into MinDistData[][][] cube
                    //  instead of int
                    MinDistData min = Stream.of(
                            new MinDistData(i - 1, j - 1, k - 1,
                                            cube[i - 1][j - 1][k - 1] + costPairIJ + costPairIK + costPairJK),
                            new MinDistData(i - 1, j - 1, k, cube[i - 1][j - 1][k] + costPairIJ + 2 * GAP_COST),
                            new MinDistData(i - 1, j, k - 1, cube[i - 1][j][k - 1] + costPairIK + 2 * GAP_COST),
                            new MinDistData(i, j - 1, k - 1, cube[i][j - 1][k - 1] + costPairJK + 2 * GAP_COST),
                            new MinDistData(i - 1, j, k, cube[i - 1][j][k] + 2 * GAP_COST),
                            new MinDistData(i, j - 1, k, cube[i][j - 1][k] + 2 * GAP_COST),
                            new MinDistData(i, j, k - 1, cube[i][j][k - 1] + 2 * GAP_COST)
                    ).min(Comparator.comparing(MinDistData::getValue)).orElseThrow();

                    cube[i][j][k] = Stream.of(costIJK, costIJ_, costI_K, cost_JK, costI__, cost_J_, cost__K)
                            .min(Integer::compareTo).orElseThrow();
                }
            }
        }
        return reconstructAlignment(cube, s1, s2, s3);
    }

    public static Alignment3 reconstructAlignment(int[][][] cube, String s1, String s2, String s3) {
        StringBuilder ssBuilder = new StringBuilder();
        StringBuilder ttBuilder = new StringBuilder();
        StringBuilder uuBuilder = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        int k = s3.length();

        // TODO: Use MinDistData saved in the cube array (replace int[][][] with MinDistData[][][])
        //  to reconstruct the optimal distance
//        while (i > 0 || j > 0 || k > 0) {
//            if (i > 0 && j > 0 && k > 0 && cube[i][j][k] == cube[i - 1][j - 1][k - 1] + )
//        }

        // TODO: 1/1/21 Deprecated
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && cube[i][j] == cube[i - 1][j - 1] + pairMatch(s1.charAt(i - 1), s2.charAt(j - 1))) {
                ssBuilder.append(s1.charAt(i - 1));
                ttBuilder.append(s2.charAt(j - 1));
                i -= 1;
                j -= 1;
            } else if (j > 0 && cube[i][j] == cube[i][j - 1] + 1) {
                ssBuilder.append("-");
                ttBuilder.append(s2.charAt(j - 1));
                j -= 1;
            } else if (i > 0 && cube[i][j] == cube[i - 1][j] + 1) {
                ssBuilder.append(s1.charAt(i - 1));
                ttBuilder.append("-");
                i -= 1;
            }
        }

        String ss = ssBuilder.reverse().toString();
        String tt = ttBuilder.reverse().toString();
        String uu = ttBuilder.reverse().toString();

        return new Alignment3(cube[s1.length()][s2.length()][s3.length()], ss, tt, uu);
    }
}

class Alignment3 {
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

class MinDistData {
    int i, j, k;
    int value;

    public MinDistData(int i, int j, int k, int value) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class CubeData {
    final int costIJK, costIJ_, costI_K, cost_JK, costI__, cost_J_, cost__K;

    CubeData(int costIJK, int costIJ_, int costI_K, int cost_JK, int costI__, int cost_J_, int cost__K) {
        this.costIJK = costIJK;
        this.costIJ_ = costIJ_;
        this.costI_K = costI_K;
        this.cost_JK = cost_JK;
        this.costI__ = costI__;
        this.cost_J_ = cost_J_;
        this.cost__K = cost__K;
    }
}

