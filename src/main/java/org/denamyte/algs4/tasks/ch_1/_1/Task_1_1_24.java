package org.denamyte.algs4.tasks.ch_1._1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collection;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.24.png" alt="Task screenshot">
 */
public class Task_1_1_24 {

    private static final Collection<EuclidPair> PAIRS = Arrays.asList(
            new EuclidPair(105, 24), new EuclidPair(1111111, 1234567));

    public static void main(String[] args) {
        PAIRS.forEach(pair -> gcdTraced(pair.p, pair.q, 1));
    }

    public static int gcdTraced(int p, int q, int traceDepth) {
        System.out.printf("Depth: %2d; p: %9d; q: %9d;\n", traceDepth, p, q);
        if (q == 0) {
            System.out.println();
            return p;
        }
        int r = p % q;
        return gcdTraced(q, r, traceDepth + 1);
    }

    @Data
    @AllArgsConstructor
    public static class EuclidPair {
        private final int p;
        private final int q;
    }

}
