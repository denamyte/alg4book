package org.denamyte.hyperskill.tasks;

import java.io.File;
import java.util.Scanner;

// src/main/resources/hyperskill/ReadingFiles_FindTheGreatestNumberInAFile/dataset_91007.txt
public class ReadingFiles_FindTheGreatestNumberInAFile {
    public static void main(String[] args) {
        try (Scanner scanner =new Scanner(new File(args[0]))) {
            System.out.println(scanner.tokens().mapToInt(Integer::parseInt).max().orElseThrow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
