package org.denamyte.hyperskill.tasks;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EditDistanceInJava_EditDistanceWithInsertionsAndDeletions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<char[]> input = Stream.generate(scanner::nextLine)
                .limit(2).sorted(Comparator.comparingInt(String::length).reversed())
                .map(String::toCharArray).collect(Collectors.toList());
        System.out.println(editDistance(input.get(0), input.get(1)));
    }

    static int editDistance(char[] s, char[] t) {
        int vert = s.length + 1;
        int horz = t.length + 1;
        int[] table = IntStream.range(0, horz).toArray();

        for (int i = 1; i < vert; i++) {
            int upperPrev = table[0];
            table[0] = i;
            for (int j = 1; j < horz; j++) {
                int upperCurr = table[j];
                table[j] = IntStream.of(table[j - 1] + 1,                             // insCost
                                        upperCurr + 1,                                // delCost
                                        upperPrev + (s[i - 1] == t[j - 1] ? 0 : 2)    // subCost
                ).min().orElseThrow();
                upperPrev = upperCurr;
            }
        }
        return table[horz - 1];
    }

}
