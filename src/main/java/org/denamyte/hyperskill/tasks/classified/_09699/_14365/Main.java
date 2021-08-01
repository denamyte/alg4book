package org.denamyte.hyperskill.tasks.classified._09699._14365;

/**
 * @see <a href="https://hyperskill.org/learn/step/14365">14365Optional -> Check an Optional value</a>
 */
public class Main {
    public static void main(String[] args) {
        ValueProvider provider = new ValueProvider();
        provider.getValue().ifPresent(System.out::println);
    }
}
