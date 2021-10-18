package org.denamyte.codility.task2021_10_15;

public class Solution1 {
    public static void main(String[] args) {
        final int[] A = {0, 1, 1, 1, 2, 2, 3, 5, 8, 8, 9, 11, 15, 15, 17, 18, 20, 20};
        final SolutionCorrect1 solution = new SolutionCorrect1();
        for (int value : A) {
            final int res = solution.solution(A, value);
            System.out.println(res);
        }
    }
}

class SolutionCorrect1 {
    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X || A[r] == X) {
            return A[l] == X ? l : r;
        }
        return -1;
    }
}
