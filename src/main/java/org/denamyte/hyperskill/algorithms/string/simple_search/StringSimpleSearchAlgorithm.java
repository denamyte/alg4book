package org.denamyte.hyperskill.algorithms.string.simple_search;

public class StringSimpleSearchAlgorithm {

    public static boolean containsPattern(String text, String pattern) {
        if (text.length() < pattern.length()) {
            return false;
        }

        final int count = text.length() - pattern.length() + 1;
        for (int i = 0; i < count; i++) {
            boolean found = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return true;
            }
        }

        return false;
    }
}
