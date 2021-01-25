package org.denamyte.hyperskill.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * <a href="https://hyperskill.org/learn/step/8843">Output streams -> Add content to a file</a>
 */
public class OutputStreams_AddContentToAFile {
    public static void main(String[] args) {
        File sampleFile = new File("sample.txt");
        byte[] content = new byte[]{'J', 'a', 'v', 'a'};

        try {
            OutputStream outputStream = new FileOutputStream(sampleFile, true);
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
