package org.denamyte.hyperskill.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//  unpack src/main/resources/hyperskill/FileHierarchies_TheDeepestFile/basedir.zip
//  to any directory and pass its path as the first argument
public class FileHierarchies_TheDeepestFile {
    public static void main(String[] args) throws IOException {
        CompareHolder holder = new CompareHolder();
        Files.walk(Path.of(args[0]))
                .map(Path::toFile)
                .filter(File::isFile)
                .forEach(file -> holder.compare(file.getName(), file.getPath().split("/").length));
        System.out.printf("The longest depth is %d and the file name is %s %n", holder.depth, holder.name);
    }

    static class CompareHolder {
        String name;
        int depth;

        void compare(String name, int depth) {
            if (depth > this.depth) {
                this.depth = depth;
                this.name = name;
            }
        }
    }
}
