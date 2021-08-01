package org.denamyte.hyperskill.tasks.other;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

/**
 * @see <a href="https://hyperskill.org/learn/step/3643">Task</a>
 */
public class FileHierarchies_FindADirectoryWithTheMaxNumberOfFiles {
    static String dirName = "";
    static int fileNumber = 0;

    public static void main(String[] args) throws IOException {
        countFiles(new File(args[0]));
//        countFiles2(args[0]);
        System.out.printf("%s %d%n", dirName, fileNumber);
    }

    static void countFiles(File dir) {
        int count = 0;
        for (File sub : Objects.requireNonNull(dir.listFiles())) {
            if (sub.isFile()) {
                count++;
                continue;
            }
            countFiles(sub);
        }
        compare(count, dir.getName());
    }

    static void countFiles2(String name) throws IOException {
        Files.walk(Path.of(name)).map(Path::toFile).forEach(file -> {
            File[] list = file.listFiles();
            if (list != null) {
                long count = Arrays.stream(list).filter(File::isFile).count();
                compare((int) count, file.getName());
            }
        });
    }

    private static void compare(int count, String name) {
        if (count > fileNumber) {
            fileNumber = count;
            dirName = name;
        }
    }
}
