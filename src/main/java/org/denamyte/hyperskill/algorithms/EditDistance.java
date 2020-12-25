package org.denamyte.hyperskill.algorithms;

import java.util.Scanner;

public class EditDistance {
    public static int match(char a, char b) {
        return (a == b) ? 0 : 1;
    }

    public static int editDistance(String s, String t) {
        int vert = s.length() + 1;
        int horz = t.length() + 1;
        int[][] d = new int[vert][horz];

        for (int i = 0; i < vert; i++) {
            d[i][0] = i;
        }

        for (int j = 0; j < horz; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < vert; i++) {
            for (int j = 1; j < horz; j++) {
                int insCost = d[i][j - 1] + 1;
                int delCost = d[i - 1][j] + 1;
                int subCost = d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1));
                d[i][j] = Math.min(Math.min(insCost, delCost), subCost);
            }
        }

        // Debug output of the distance table
        for (int[] line : d) {
            for (int value : line) {
                System.out.printf("%d  ", value);
            }
            System.out.println();
        }

        return d[s.length()][t.length()];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(editDistance(
                scanner.next(), scanner.next()
        ));
    }
}
