package org.denamyte.algs4.code;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Histogram {

    /**
     * @param a An array containing some integer values
     * @param m The upper border in a range [0..m]
     * @return an array of length <b><i>m</i></b> whose <b><i>i</i></b>th entry is the number
     * of times the integer <b><i>i</i></b> appeared in the argument array
     */
    public static int[] histogram(int[] a, int m) {
        if (ArrayUtils.getLength(a) == 0 || m <= 0) {
            throw new IllegalArgumentException("either the array a has zero length or the variable m <= 0");
        }
        Collection<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        int[] hist = new int[m];
        for (int i = 0; i < m; i++) {
            int ii = i;
            hist[i] = (int) list.stream().filter(value -> value == ii).count();
        }
        return hist;
    }
}
