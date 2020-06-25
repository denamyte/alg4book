package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.denamyte.algs4.code.EuclidsAlgorithm;
import org.denamyte.algs4.code.utils.ParamsInt2;
import org.denamyte.algs4.code.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.30.png" alt="Task screenshot">
 */
public class Task_1_1_30 {

    private static final Map<ParamsInt2, Boolean> primeMap = new HashMap<>();

    public static void main(String[] args) {
        while (Utils.stdInInviteAndCheck("Enter an integer (square matrix size) in the range [1..100]")) {
            int size = StdIn.readInt();
            if (size < 1 || size > 100) {
                StdOut.printf("The matrix size must be in range. Integer %d is out of range [1..100]\n", size);
                continue;
            }
            boolean[][] primes = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    primes[i][j] = relativelyPrime(i + 1, j + 1);
                }
            }
            print(primes);
        }
    }

    public static boolean relativelyPrime(int i, int j) {
        if (i <= 0 || j <= 0) {
            throw new IllegalArgumentException("parameters should be greater than 0");
        }
        return getFromCache(i, j);
    }

    public static boolean getFromCache(int i, int j) {
        return primeMap.computeIfAbsent(new ParamsInt2(i, j), paramsInt2 -> EuclidsAlgorithm.gcd(i, j) == 1);
    }

    public static void print(boolean[][] primes) {
        int size = primes[0].length;
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int i = 0; i < size; i++) {
            sb.append(String.format("%3d", i + 1));
        }
        sb.append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(String.format("%3d", i + 1));
            for (int j = 0; j < size; j++) {
                sb.append(String.format("%3s", primes[i][j] ? "+" : "-"));
            }
            sb.append("\n");
        }
        StdOut.print(sb.toString());
    }

}
