package org.denamyte.hyperskill.tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <a href="https://hyperskill.org/learn/step/8844">Output streams -> Choose correct writer</a>
 */
public class OutputStreams_ChooseCorrectWriter {
    public static void main(String[] args) throws IOException {
        File sampleFile = new File("sample.txt");
        String content = "Streams are easy!";
        FileWriter writer = new FileWriter(sampleFile);
        writer.write(content);
        writer.close();
    }
}
