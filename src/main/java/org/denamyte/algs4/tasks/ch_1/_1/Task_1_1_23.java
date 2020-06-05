package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.23.png" alt="Task screenshot">
 */
public class Task_1_1_23 {

    /**
     * If the second argument is '+': the program will print numbers that ARE NOT in the whitelist;<br>
     * If the second argument is '-': the program will print numbers that ARE in the whitelist.
     *
     * @param args args[0] - the file name for whitelist; args[1] - '+' or '-'.
     */
    public static void main(String[] args) {
        // read the integers from a file
        In in = new In(args[0]);
        String sign = checkSign(args[1]);
        boolean printFound = sign.equals("-");
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexOf(whitelist, key) == -1) {  // i.e. not found
                if (!printFound)
                    StdOut.println(key);
            } else /*i.e. found*/ if (printFound)
                StdOut.println(key);
        }
    }

    public static String checkSign(String sign) {
        if (!"+".equals(sign) && !"-".equals(sign)) {
            throw new IllegalArgumentException("The second argument must be '+' or '-'");
        }
        return sign;
    }
}
