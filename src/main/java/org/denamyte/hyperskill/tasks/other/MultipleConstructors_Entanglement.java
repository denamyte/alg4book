package org.denamyte.hyperskill.tasks.other;


/**
 * <a href="https://hyperskill.org/learn/step/2175">Multiple constructors -> Entanglement</a>
 */
public class MultipleConstructors_Entanglement {

    public static void main(String[] args) {
        SomeClass instance = new SomeClass(300, "another-value");
        System.out.printf("val: %d, str: %s", instance.val, instance.str);
    }
    static class SomeClass {

        int val = 50;
        String str = "default";

        public SomeClass() {
            this(100);
        }

        public SomeClass(int val) {
            val = val;
        }

        public SomeClass(String str) {
            this();
            this.str = "some-value";
        }

        public SomeClass(int val, String str) {
            this(str);
        }
    }
}
