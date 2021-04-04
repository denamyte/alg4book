package org.denamyte.hyperskill.algorithms.string.edit_distance_alignment;

public class EditDistanceAlignment {

    public static void main(String[] args) {
        Alignment alignment = editDistanceAlignment("editing", "distance");
        System.out.println(alignment);
    }

    public static int match(char a, char b) {
        return (a == b) ? 0 : 1;
    }

    public static Alignment editDistanceAlignment(String s, String t) {
        int[][] d = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            d[i][0] = i;
        }

        for (int j = 0; j < t.length() + 1; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                int insCost = d[i][j - 1] + 1;
                int delCost = d[i - 1][j] + 1;
                int subCost = d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1));
                d[i][j] = Math.min(Math.min(insCost, delCost), subCost);
            }
        }

        return reconstructAlignment(d, s, t);
    }

    public static Alignment reconstructAlignment(int[][] d, String s, String t) {
        StringBuilder ssBuilder = new StringBuilder();
        StringBuilder ttBuilder = new StringBuilder();
        int i = s.length();
        int j = t.length();

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && d[i][j] == d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1))) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append(t.charAt(j - 1));
                i -= 1;
                j -= 1;
            } else if (j > 0 && d[i][j] == d[i][j - 1] + 1) {
                ssBuilder.append("-");
                ttBuilder.append(t.charAt(j - 1));
                j -= 1;
            } else if (i > 0 && d[i][j] == d[i - 1][j] + 1) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append("-");
                i -= 1;
            }
        }

        String ss = ssBuilder.reverse().toString();
        String tt = ttBuilder.reverse().toString();

        return new Alignment(d[s.length()][t.length()], ss, tt);
    }
}
