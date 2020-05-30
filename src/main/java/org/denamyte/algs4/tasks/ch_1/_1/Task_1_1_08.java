package org.denamyte.algs4.tasks.ch_1._1;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.08.png" alt="Task screenshot">
 */
public class Task_1_1_08 {
    public static void main(String[] args) {
        System.out.println("System.out.println('b') will print the symbol 'b':");
        System.out.println('b');
        System.out.println(
                "\nSystem.out.println('b' + 'c'): chars 'b' and 'c' get \n" +
                        "converted to integers (98 + 99), according to the rule \n" +
                        "of character summation, then they get summed up and printed:");
        System.out.println('b' + 'c');
        System.out.println(
                "\nSystem.out.println((char) ('a' + 4)): ('a' + 4)\n" +
                        "get converted to (97 + 4), summed up (101) and converted\n" +
                        "to the char 'e', then printed:");
        System.out.println((char) ('a' + 4));
    }
}
