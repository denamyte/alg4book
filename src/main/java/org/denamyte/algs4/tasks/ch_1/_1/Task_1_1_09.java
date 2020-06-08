package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.09.png" alt="Task screenshot">
 */
public class Task_1_1_09 {

    private static final List<String[]> arguments;

    static {
        double pow10 = Math.pow(2, 10);
        double pow12 = Math.pow(2, 12);
        arguments = Stream.of(pow10 - 1, pow10, pow10 + 1, pow12 - 1, pow12, pow12 + 1)
                .map(Double::intValue)
                .map(String::valueOf)
                .map(s -> new String[]{s}).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        arguments.forEach(BinaryRepresentation::main);
    }

    public static class BinaryRepresentation {
        public static void main(String[] args) {
            if (args.length == 0) {
                throw new IllegalArgumentException(Arrays.toString(args));
            }
            Map<Integer, String> results = Stream.of(args)
                    .map(Integer::parseInt)
                    .collect(Collectors.toMap(Function.identity(), BinaryRepresentation::integerToString, (s, s2) -> s));

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

}
