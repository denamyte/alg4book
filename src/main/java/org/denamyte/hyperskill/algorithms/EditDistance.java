package org.denamyte.hyperskill.algorithms;

import java.util.Scanner;

public class EditDistance {
    public static int match(char a, char b) {
        return (a == b) ? 0 : 1;
    }

    public static int editDistance(String s, String t) {
        int[][] distTable = calcDistanceTable(s, t);
        return distTable[s.length()][t.length()];
    }

    public static int editDistanceOutput(String s, String t) {
        int[][] distTable = calcDistanceTable(s, t);
        s = s.toUpperCase();
        t = t.toUpperCase();

        String[][] showTable = new String[s.length() + 2][t.length() + 2];
        // the 2 leading spaces in the first column and first row
        for (int i = 0; i < 2; i++)
            showTable[0][i] = showTable[i][0] = " ";

        // the first word (vertical)
        for (int i = 2; i < s.length() + 2; i++)
            showTable[i][0] = String.valueOf(s.charAt(i - 2));

        // the second word (horizontal)
        for (int j = 2; j < t.length() + 2; j++)
            showTable[0][j] = String.valueOf(t.charAt(j - 2));

        // copy distTable into showTable
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < t.length() + 1; j++) {
                showTable[i + 1][j + 1] = String.valueOf(distTable[i][j]);
            }
        }

        for (String[] line : showTable) {
            for (String value : line) {
                System.out.printf("%s  ", value);
            }
            System.out.println();
        }

        return distTable[s.length()][t.length()];
    }

    private static int[][] calcDistanceTable(String s, String t) {
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
        return d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(editDistanceOutput(
                scanner.next(), scanner.next()
        ));
    }
}
