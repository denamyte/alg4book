package org.denamyte.codility.task2021_10_15;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TricoloringArray {
    public static void main(String[] args) {
        Stream.of(new int[]{3, 7, 2, 5, 4},
                  new int[]{3, 1, 2, 2, 1},
                  new int[]{3, 1, 1, 3, 1},
                  new int[]{100},
                  new int[]{100, -130},
                  new int[]{100, -130, 1, 51, 2, 25, 5, -99, 10, -9, 3, 14, -7, 49, 14, 143, -120, 8, -1},
                  new int[]{100, -130, 1, 51, 2, 25, 5, -99, 10, -9, 3, 14, -7, 49, 14, 143, -120, 8, -1, -1},
                  new int[]{100, -130, 1, 51, 2, 25, 5, -99, 10, -9, 3, 14, -7, 49, 14, 143, -120, 8, -1, -1, -1},
                  new int[]{100, -130, 1, 51, 2, 25, 5, -99, 10, -9, 3, 14, -7, 49, 14, 143, -120, 8},
                  new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3},
                  new int[]{1, 2, 1, 1, 3, 1, 2, 1, 2, 1, 3})
                .map(new Solution()::solution)
                .forEach(System.out::println);
    }
}

class Solution {

    private static final Map<Integer, String> colorMap = Map.of(
            0, "B",
            1, "R",
            2, "G"
    );

    private int[] A;
    private int N;
    private int colorSum;
    private int colorNumber;

    public String solution(int[] A) {
        this.A = A;
        N = A.length;
        if (N <= 2) {
            return "impossible";
        }
        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0) {
            return "impossible";
        }
        colorNumber = colorMap.size();
        colorSum = sum / colorNumber;

        final int[] colors = arrangeColors(new int[N], 1, 0, 0, 0);
        if (colors != null) {
            return IntStream.of(colors).mapToObj(colorMap::get).collect(Collectors.joining());
        }
        return "impossible";
    }

    private int[] arrangeColors(int[] colorArray,
                                  int currentColor,
                                  int occupiedCellsCount,
                                  int nextIndex,
                                  int currentSum) {
        while ((nextIndex = findFirstZeroIndex(colorArray, nextIndex)) != -1) {

            int[] colorArrayCopy = Arrays.copyOf(colorArray, N);
            colorArrayCopy[nextIndex] = currentColor;

            if (currentSum + A[nextIndex] == colorSum) {  // The current color is set up

                // The current color is the last color to check (it is the second to last color)
                if (currentColor + 1 == colorNumber) {
                    return colorArrayCopy;
                }

                // The next color is to be checked as well
                return arrangeColors(colorArrayCopy,
                                     currentColor + 1,
                                     occupiedCellsCount + 1,
                                     0, 0);
            }

            if (notEnoughRoomForOtherColors(currentColor, occupiedCellsCount + 1)) {
                return null;
            }

            colorArrayCopy = arrangeColors(colorArrayCopy,
                                           currentColor,
                                           occupiedCellsCount + 1,
                                           nextIndex + 1,
                                           currentSum + A[nextIndex]);
            if (colorArrayCopy != null) {
                return colorArrayCopy;
            }

            nextIndex += 1;
        }

        return null;
    }

    private boolean notEnoughRoomForOtherColors(int currentColor, int occupiedCellsCount) {
        return N - occupiedCellsCount <= colorNumber - currentColor;
    }

    private int findFirstZeroIndex(int[] colorArray, int startFrom) {
        for (int i = startFrom; i < N; i++) {
            if (colorArray[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}

