package org.denamyte.hyperskill.tasks.classified._16616;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HowManyRepetitions {
    final static String PATH = "/home/denamyte/shared/projects/study/coursera/princeton-alg/algorithms/alg4book/src/main/java/org/denamyte/hyperskill/tasks/classified/_16616/hyperskill-dataset-48641242.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(PATH))) {
            String number = scanner.nextLine();
            final String[] set = scanner.nextLine().split("\\s+");
            System.out.println(
                    Arrays.stream(set)
                            .filter(s -> s.equals(number))
                            .count()
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
