package org.denamyte.hyperskill.tasks;

import java.util.Scanner;

public class DynamicArrayInJava_AllocatedMemory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandsCount = scanner.nextInt();
        double growFactor = scanner.nextDouble();
        double shrinkFactor = Double.parseDouble(scanner.nextLine());

        int memory = 2;
        int size = 0;
        while (commandsCount > 0) {
            String[] cmd = scanner.nextLine().split(" ");
            switch (cmd[0]) {
                case "add":
                    size += Integer.parseInt(cmd[1]);
                    double newMemory = memory;
                    while (newMemory < size) {
                        newMemory *= growFactor;
                    }
                    memory = (int) newMemory;
                    break;
                case "delete":
                    size -= Integer.parseInt(cmd[1]);  // no checks for a negative newSize
                    double shrunkMemory = memory;
                    while (shrunkMemory >= size) {
                        shrunkMemory /= shrinkFactor;
                    }
                    memory = (int) (shrunkMemory * shrinkFactor);
                    break;
                default: System.out.println(memory);
            }
            commandsCount--;
        }
    }
}
