package org.denamyte.hyperskill.tasks.classified._16625;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href="https://hyperskill.org/learn/daily/16625">Binary search -> Count of loop operations</a>
 */
public class CountOfLoopOperations {
    private static final String fileName = "/home/denamyte/shared/projects/study/coursera/princeton-alg/algorithms/alg4book/src/main/java/org/denamyte/hyperskill/tasks/classified/_16625/hyperskill-dataset-48782347.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            String s = scanner.nextLine();
            s = s.replaceAll("[\\[\\]]", "");
            final int[] ar = Arrays.stream(s.split(", ?"))
                    .map(Integer::parseInt)
                    .mapToInt(value -> value).toArray();
            System.out.println(
                    Arrays.stream(ar)
                            .map(value -> binaryLoopCount(ar, value))
                            .sum()
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int binaryLoopCount(int[] ar, int value) {
        int loopCounter = 0;
        int left = 0;
        int right = ar.length - 1;
        while (left <= right) {
            loopCounter++;
            int middle = left + (right - left) / 2;
            if (ar[middle] == value) {
                return loopCounter;
            }
            if (ar[middle] > value) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return loopCounter;
    }
}
