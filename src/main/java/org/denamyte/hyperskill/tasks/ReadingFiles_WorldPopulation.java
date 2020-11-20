package org.denamyte.hyperskill.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//  /home/denamyte/shared/projects/study/coursera/princeton-alg/algorithms/alg4book/src/main/java/org/denamyte/hyperskill/files/dataset_91069.txt
public class ReadingFiles_WorldPopulation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/home/denamyte/shared/projects/study/coursera/princeton-alg/algorithms/alg4book/src/main/java/org/denamyte/hyperskill/files/dataset_91069.txt"))) {
            scanner.nextLine();
            long[] loYear = getYear(scanner);
            long maxYear = 0, maxPopGrowth = 0;
            while (scanner.hasNext()) {
                long[] hiYear = getYear(scanner);
                long growth = hiYear[1] - loYear[1];
                if (growth > maxPopGrowth) {
                    maxYear = hiYear[0];
                    maxPopGrowth = growth;
                }
                loYear = hiYear;
            }
            System.out.println(maxYear);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static long[] getYear(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(s -> s.replace(",", "")).mapToLong(Long::parseLong).toArray();
    }
}
