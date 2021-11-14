package org.denamyte.hyperskill.tasks.classified._16626;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href="https://hyperskill.org/learn/daily/16626">Binary search -> Approximate search</a>
 */
public class ApproximateSearch {

    private static final String PATH = "/home/denamyte/shared/projects/study/coursera/princeton-alg/algorithms/alg4book/src/main/java/org/denamyte/hyperskill/tasks/classified/_16626/hyperskill-dataset-48957742.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(PATH))) {
            int[] array = parseString(scanner.nextLine());
            int[] values = parseString(scanner.nextLine());
            Arrays.stream(values)
                    .map(value -> findNearestBinarySearch(array, value))
                    .forEach(result -> System.out.printf("%d ", result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[] parseString(String s) {
        return Arrays.stream(s.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static int findNearestBinarySearch(int[] a, int number) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (a[middle] == number) {
                return number;
            } else if (a[middle] > number) {
                if (a[middle - 1] <= number) {
                    return a[middle] - number < number - a[middle - 1] ? a[middle] : a[middle - 1];
                }
                right = middle - 1;
            } else {
                if (a[middle + 1] >= number) {
                    return number - a[middle] <= a[middle + 1] - number ? a[middle] : a[middle + 1];
                }
                left = middle + 1;
            }
        }
        return a[left];
    }
}
