package org.denamyte.algs4.code;

/**
 * Contains Euclid's algorithm - search for the greatest common divider
 */
public class EuclidsAlgorithm {

    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

}
