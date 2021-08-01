package org.denamyte.hyperskill.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href="https://hyperskill.org/learn/step/13809">Binary search -> Number of iterations</a>
 * Path = src/main/resources/hyperskill/data/BinarySearch_NumberOfIterations/hyperskill-dataset-42119809.txt
 */
public class BinarySearch_NumberOfIterations {

    private static final String PATH = "/home/denamyte/shared/projects/study/coursera/princeton-alg/algorithms/alg4book/src/main/resources/hyperskill/data/BinarySearch_NumberOfIterations/hyperskill-dataset-42119809.txt";
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(PATH))) {
            String s = scanner.nextLine();
            System.out.println(s);
            int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int counter = binarySearchCounter(numbers, 12, 0, numbers.length - 1, 0);
            System.out.println(counter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int binarySearchCounter(int[] ar, int target, int lo, int hi, int count) {
        if (lo > hi)
            return count;
        int mid = (lo + hi) / 2;
        count++;
        if (ar[mid] == target) {
            return count;
        }
        if (ar[mid] < target) {
            return binarySearchCounter(ar, target, mid + 1, hi, count);
        }
        return binarySearchCounter(ar, target, lo, mid - 1, count);
    }
}
