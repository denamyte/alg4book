package org.denamyte.algs4.code;

public class MysterySumAndMultiplication {

    public static int mystery(int a, int b) {
        if (b == 0)
            return 0;
        int res = mystery(a + a, b / 2);
        if (b % 2 == 0)
            return res;
        return res + a;
    }

    public static int mysteryMult(int a, int b) {
        if (b == 0)
            return 1;
        int res = mysteryMult(a * a, b / 2);
        if (b % 2 == 0)
            return res;
        return res * a;
    }
}
