package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdOut;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.27.png" alt="Task screenshot">
 */
public class Task_1_1_27 {
    public static void main(String[] args) {
        int N = 100, k = 50;
        double p = 0.3;
        StdOut.println("Here are all the unique combinations of arguments in the following recursive call:");
        double value = binomial2(N, k, p);
        System.out.printf("\nThe result of binomial2(%d, %d, %f) is %f\n", N, k, p, value);
        System.out.printf("The size of cache of recursive calls results: %d\n", results.size());
    }

    public static double binomial(int N, int k, double p) {
        System.out.println(new BinomialArgs(N, k));
        if ((N == 0) || (k < 0))
            return 1.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    private static final Map<BinomialArgs, Double> results = new ConcurrentHashMap<>();

    public static double binomial2(int N, int k, double p) {
        if ((N == 0) || (k < 0))
            return 1.0;
        double v1 = getBinomialValue(N - 1, k, p);
        double v2 = getBinomialValue(N - 1, k - 1, p);
        return (1.0 - p) * v1 + p * v2;
    }

    public static double getBinomialValue(int n, int k, double p) {
        Double value;
        BinomialArgs args = new BinomialArgs(n, k);
        value = results.get(args);
        if (value == null) {
            StdOut.println(args);
            value = binomial2(n, k, p);
            results.put(args, value);
        }
        return value;
    }

    @AllArgsConstructor
    @Data
    private static class BinomialArgs {
        private int n;
        private int k;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof BinomialArgs)) {
                return false;
            }
            BinomialArgs other = (BinomialArgs) obj;
            return other.n == n && other.k == k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, k);
        }
    }

}
