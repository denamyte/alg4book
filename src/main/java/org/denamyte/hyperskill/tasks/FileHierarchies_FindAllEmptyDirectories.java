package org.denamyte.hyperskill.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * @see <a href="https://hyperskill.org/learn/step/3644">Task</a>
 */
public class FileHierarchies_FindAllEmptyDirectories {
    public static void main(String[] args) throws IOException {
        String emptyDirStr = Files.walk(Path.of(args[0]))
                .map(Path::toFile)
                .filter(File::isDirectory)
                .filter(dir -> dir.listFiles().length == 0)
                .map(File::getName)
                .collect(Collectors.joining(" "));
        System.out.println(emptyDirStr);
    }
}
