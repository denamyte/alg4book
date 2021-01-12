package org.denamyte.hyperskill.algorithms.decomposition;

/**
 * In this task, you'll need to find out all decompositions of number N(1≤N≤40)
 * and list its positive addends.
 * The decomposition should be printed in lexicographical order.
 *
 * @see <a href="https://hyperskill.org/learn/step/3126">Recursion -> Number of decompositions</a>
 */
public class NumberOfDecompositions {

    static final int MIN = 1, MAX = 40;
    final int number;

    public NumberOfDecompositions(int number) {
        this.number = number;
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(String.format("Enter number in the range (%d..%d)", MIN, MAX));
        }
        decompose2(number, number, null);
    }

    private void decompose(int number, int max, String prefix) {
        if (number == 0) {
            System.out.println(prefix);
            return;
        }
        int newMax = Math.min(number, max);
        for (int i = 1; i <= newMax ; i++) {
            String newPrefix = prefix == null ? "" + i : String.format("%s %d", prefix, i);
            decompose(number - i, i, newPrefix);
        }
    }

    private void decompose2(int number, int max, String prefix) {
        for (int i = 1; i <= max ; i++) {
            String newPrefix = prefix == null ? "" + i : prefix + ' ' + i;
            int nextNum = number - i;
            if (nextNum == 0) {
                System.out.println(newPrefix);
                return;
            }
            decompose2(nextNum, Math.min(nextNum, i), newPrefix);
        }
    }

    public static void main(String[] args) {
        new NumberOfDecompositions(10);
    }
}
