package org.denamyte.codility;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution1 {
    public int solution(int[] A) {
        Set<Integer> set = new TreeSet<>();
        for (int value: A) {
            if (value >= 1 && value <= 100_000) {
                set.add(value);
            }
        }
        AtomicInteger counter = new AtomicInteger();
        for (Integer value : set) {
            if (value != counter.incrementAndGet()) {
                return counter.get();
            }
        }
        return counter.incrementAndGet();
    }

    public static void main(String[] args) {
//        final int result = new Solution().solution(new int[]{1, 30, 6, 4, 2, 1, -1000, 1000, 10_000, 100_001});
        final int result = new Solution1().solution(new int[]{3, 2, 4, 5, 1, 1, 2, 5, 6, 8, 7, 9});
        System.out.println(result);
    }
}
