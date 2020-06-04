package org.denamyte.algs4.tasks.ch_1._1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * <img src="../../docs/ch_1/_1/Task.1.1.21.png" alt="Task screenshot">
 */
public class Task_1_1_21 {
    public static void main(String[] args) {
        Collection<Grade> grades = readLines();
        printTabularOutput(grades);
    }

    private static Collection<Grade> readLines() {
        List<Grade> grades = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] split = line.split(" ");
            if (split.length != 3) {
                throw new IllegalArgumentException("The quantity of input values is not equal 3");
            }
            try {
                grades.add(new Grade(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("The input integers are wrong: " + e.getMessage());
            }
        }
        return grades;
    }

    private static void printTabularOutput(Collection<Grade> grades) {
        grades.forEach(grade -> StdOut.printf("%15s:%11d%11d%10.3f\n"
                , grade.name, grade.int1, grade.int2, (double) grade.int1 / grade.int2));
    }

    @AllArgsConstructor
    private static class Grade {
        private final String name;
        private final int int1;
        private final int int2;
    }
}
