package org.denamyte.hyperskill.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;

// src/main/resources/hyperskill/ReadingFiles_CountEvenNumbers/dataset_91065.txt
public class ReadingFiles_CountEvenNumbers {
    public static void main(String[] args) {
        String filePath = args[0];
        try (Scanner scanner = new Scanner(new File(filePath))) {
            long count = Stream.generate(scanner::nextInt).takeWhile(value -> value != 0)
                    .filter(value -> value % 2 == 0).count();
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
