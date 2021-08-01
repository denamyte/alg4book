package org.denamyte.hyperskill.tasks.other;

import java.io.ByteArrayOutputStream;

/**
 * <a href="https://hyperskill.org/learn/step/8845">Output streams -> Secret message</a>
 */
public class OutputStreams_SecretMessage {
    public static void main(String[] args) {
        int[] message = new int[] {114, 101, 97, 100, 32, 97, 98, 111, 117, 116, 32, 65, 83, 67, 73, 73};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int code : message) {
            outputStream.write(code);
        }

        System.out.println(outputStream.toString());
    }
}
