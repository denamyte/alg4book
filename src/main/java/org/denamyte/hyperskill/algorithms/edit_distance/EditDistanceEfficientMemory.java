package org.denamyte.hyperskill.algorithms.edit_distance;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** This edit distance algorithms Uses only 1 array of min(|s|, |t|) length. */
public class EditDistanceEfficientMemory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Stream.generate(scanner::nextLine)
                .limit(2).sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println(editDistance2(input.get(0), input.get(1)));
    }

    static int editDistance2(String s, String t) {
        int vert = s.length() + 1;
        int horz = t.length() + 1;

        int[] table = new int[horz];

        for (int j = 0; j < horz; j++) {
            table[j] = j;
        }

        int upperPrev, upperCurr;
        for (int i = 1; i < vert; i++) {
            upperPrev = table[0];
            table[0] = i;
            for (int j = 1; j < horz; j++) {
                upperCurr = table[j];
                table[j] = IntStream.of(
                        table[j - 1] + 1,   // insCost
                        upperCurr + 1,      // delCost
                        upperPrev + match(s.charAt(i - 1), t.charAt(j - 1))).min().orElseThrow();  // subCost
                upperPrev = upperCurr;
            }
        }
        return table[horz - 1];
    }

    static int match(char a, char b) {
        return a == b ? 0 : 1;
    }

}
