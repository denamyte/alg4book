package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;
import org.denamyte.algs4.code.utils.Utils;

import java.util.Arrays;
import java.util.Collection;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.03.png" alt="Task screenshot">
 */
public class Task_1_1_03 {
    public static Collection<String[]> arguments = Arrays.asList(
            new String[] {"1", "2", "3"},
            new String[] {"1", "2", "2"},
            new String[] {"1", "1", "2"},
            new String[] {"2", "2", "2"}
    );

    public static void main(String[] args) {
        arguments.forEach(EqualNotEqual::main);
    }

    public static class EqualNotEqual {
        public static void main(String[] args) {
            Utils.checkArgsLength(args.length, 3);
            int[] a = new int[3];
            for (int i = 0; i < 3; i++) {
                a[i] = Integer.parseInt(args[i]);
            }
            StdOut.println(Arrays.toString(a));
            for (int i = 1; i < 3; i++) {
                if (a[i] != a[i - 1]) {
                    StdOut.printf("not equal\n%d != %d\n\n", a[i - 1], a[i]);
                    return;
                }
            }
            StdOut.print("equal\n\n");
        }
    }

}
