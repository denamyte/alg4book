package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.20.png" alt="Task screenshot">
 */
public class Task_1_1_20 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1000, 2000, 5000));
        StdOut.println("Descending algorithm:");
        list.forEach(n -> StdOut.printf("ln(%d!) = %f\n", n, lnNFactorial(n)));
        StdOut.println("\nAscending algorithm:");
        list.forEach(n -> StdOut.printf("ln(%d!) = %f\n", n, lnNFactorialAsc(n, 1, 0)));
        list.addAll(Arrays.asList(12000, 50_000, 100_000, 1_000_000));
        StdOut.println("\nWithout recursion:");
        list.forEach(n -> StdOut.printf("ln(%d!) = %f\n", n, lnNFactorialNoRec(n)));
    }

    /**
     * Calculates the value of <code>ln(n!)</code>
     * @param n The base of factorial
     */
    public static double lnNFactorial(long n) {
        if (n == 1)
            return Math.log(1);
        return lnNFactorial(n - 1) + Math.log(n);
    }

    /**
     * Calculates the value of <code>ln(n!) in an ascending way</code>
     * @param n The base of factorial
     * @param curN The current base, ascending
     * @param res The current result
     */
    public static double lnNFactorialAsc(long n, long curN, double res) {
        double log = Math.log(curN);
        if (n == curN) {
            return res + log;
        }
        return lnNFactorialAsc(n, curN + 1, res + log);
    }

    /**
     * Calculates the value of <code>ln(n!)</code> without a recursion
     * @param n The base of factorial
     */
    public static double lnNFactorialNoRec(long n) {
        double res = 0;
        for (long i = 1; i <= n; i++) {
            res += Math.log(i);
        }
        return res;
    }
}
