package org.denamyte.hyperskill.tasks;

import java.util.Map;
import java.util.Scanner;

public class EditDistanceInJava_EditDistanceWithAScoringMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();
        int dataSize = Integer.parseInt(scanner.nextLine());
        int minDistance = Integer.MAX_VALUE;
        String matchedData = request;
        for (int i = 0; i < dataSize; i++) {
            String data = scanner.nextLine();
            int dist = editDistance(request, data);
            if (dist < minDistance) {
                minDistance = dist;
                matchedData = data;
            }
        }
        System.out.println(minDistance);
        System.out.println(matchedData);
    }

    static int editDistance(String s, String t) {
        int[][] distTable = calcDistanceTable(s, t);
        return distTable[s.length()][t.length()];
    }

    static int[][] calcDistanceTable(String s, String t) {
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

    static int match(char a, char b) {
        return (a == b) ? 0 : matchWithScoringTable(a, b);
    }

    static int matchWithScoringTable(char a, char b) {
        if (scoringIndices.containsKey(a) && scoringIndices.containsKey(b)) {
            int aInd = scoringIndices.get(a);
            int bInd = scoringIndices.get(b);
            return scoringTable[aInd][bInd];
        }
        return 1;
    }

    static Map<Character, Integer> scoringIndices = Map.of(
            'a', 0, 's', 1, 'd', 2, 'b', 3, 'n', 4, 'm', 5
    );

    static int[][] scoringTable = new int[][]{
            //   a  s  d  b  n  m
            {0, 1, 2, 5, 6, 7},  // a
            {1, 0, 1, 5, 6, 7},  // s
            {2, 1, 0, 5, 6, 7},  // d
            {5, 6, 7, 0, 1, 2},  // b
            {5, 6, 7, 1, 0, 1},  // n
            {5, 6, 7, 2, 1, 0},  // m
    };

    /** Shows the full transformation matrix from the word s to the word t. */
    static void editDistanceOutput(String s, String t) {
        int[][] distTable = calcDistanceTable(s, t);
        s = s.toUpperCase();
        t = t.toUpperCase();

        String[][] showTable = new String[s.length() + 2][t.length() + 2];
        // set the first 2 spaces in the first column and first row
        for (int i = 0; i < 2; i++)
            showTable[0][i] = showTable[i][0] = " ";

        // set the first word (vertical)
        for (int i = 2; i < s.length() + 2; i++)
            showTable[i][0] = String.valueOf(s.charAt(i - 2));

        // set the second word (horizontal)
        for (int j = 2; j < t.length() + 2; j++)
            showTable[0][j] = String.valueOf(t.charAt(j - 2));

        // copy the other values from distTable into showTable
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
    }
}
