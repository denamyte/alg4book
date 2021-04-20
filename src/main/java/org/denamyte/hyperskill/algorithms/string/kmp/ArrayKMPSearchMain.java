package org.denamyte.hyperskill.algorithms.string.kmp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayKMPSearchMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayContainer pattern = ArrayContainer.input(scanner);
        ArrayContainer text = ArrayContainer.input(scanner);
        if (pattern.cols > text.cols || pattern.rows > text.rows) {
            System.out.println(0);
            return;
        }
        System.out.println(new ArrayKMPSearch(pattern, text).search());
    }

}

class ArrayContainer {
    public final String[] ar;
    public final int rows;
    public final int cols;

    private ArrayContainer(String[] ar, int rows, int cols) {
        this.ar = Arrays.copyOf(ar, ar.length);
        this.rows = rows;
        this.cols = cols;
    }

    public static ArrayContainer input(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[] ar = new String[rows];
        for (int r = 0; r < rows; r++) {
            ar[r] = scanner.nextLine();
        }
        return new ArrayContainer(ar, rows, cols);
    }
}

class ArrayKMPSearch {

    public final ArrayContainer patternCont;
    public final ArrayContainer textCont;
    public final int[] prefixFunc;

    public ArrayKMPSearch(ArrayContainer patternCont, ArrayContainer textCont) {
        this.patternCont = patternCont;
        prefixFunc = prefixFunction(patternCont.ar[0]);
        this.textCont = textCont;
    }

    public int search() {
        int[][] prefixFunc = new int[patternCont.rows][];
        for (int row = 0; row < patternCont.rows; row++) {
            prefixFunc[row] = prefixFunction(patternCont.ar[row]);
        }
        int minLastBound = IntStream.range(0, patternCont.rows)
                .map(ind -> prefixFunc[ind][patternCont.cols - 1])
                .min().orElseThrow();

        return arrayKMPSearch(textCont, patternCont, prefixFunc, minLastBound);
    }

    public static int[] prefixFunction(String str) {
        int[] prefixFunc = new int[str.length()];

        for (int i = 1; i < str.length(); i++) {
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            prefixFunc[i] = j;
        }

        return prefixFunc;
    }

    public static int arrayKMPSearch(ArrayContainer text, ArrayContainer pattern,
                                     int[][] prefixFunc, int minLastBound) {
        int foundCount = 0;

        int textRowShift = text.rows - pattern.rows;
        while (textRowShift >= 0) {  // Start comparing from the bottom strings of the text

            int j = 0;
            for (int i = 0; i < text.cols; i++) {

                while (true) {
                    int notEqualRow = getRowIndexWhereColumnsAreNotEqual(text.ar, pattern.ar, textRowShift, i, j);
                    if (notEqualRow > -1) {  // Signifies, that columns are not equal
                        if (j > 0) {
                            j = prefixFunc[notEqualRow][j - 1];
                        } else {
                            break;
                        }
                    } else {
                        j += 1;
                        break;
                    }
                }

                if (j == pattern.cols) {
                    foundCount++;
                    j = minLastBound;
                }
            }
            textRowShift--;
        }
        return foundCount;
    }

    private static int getRowIndexWhereColumnsAreNotEqual(String[] tAr, String[] pAr, int rowShift, int i, int j) {
        for (int pArRow = 0; pArRow < pAr.length; pArRow++) {
            if (tAr[rowShift + pArRow].charAt(i) != pAr[pArRow].charAt(j)) {
                return pArRow;  // The index of the row of the prefixFunc to change the j variable
            }
        }
        return -1;
    }

}
