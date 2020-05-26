package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <img src="../../docs/Task.1.1.09.png" alt="Task screenshot">
 */
public class Task_1_1_09 {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(Arrays.toString(args));
        }
        Map<Integer, String> results = Stream.of(args)
                .map(Integer::parseInt)
                .collect(Collectors.toMap(Function.identity(), Task_1_1_09::integerToString, (s, s2) -> s));

        results.forEach((key, value) -> StdOut.printf("%10d: %s\n", key, value));
    }

    public static String integerToString(int number) {
        if (number < 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = number; i > 0; i /= 2) {
            sb.append(i % 2);
        }
        return sb.reverse().toString();
    }
}
