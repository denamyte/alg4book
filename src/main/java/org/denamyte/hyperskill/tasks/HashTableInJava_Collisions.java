package org.denamyte.hyperskill.tasks;

import org.denamyte.hyperskill.structures.hash_table.CustomHashTable;

public class HashTableInJava_Collisions {
    public static void main(String[] args) {
        CustomHashTable<String> table = new CustomHashTable<>(5);
        table.put(10, "John");
        table.put(20, "Alice");
        table.put(30, "Kate");
        table.put(44, "Tom");
        table.put(31, "Ann");
        table.put(12, "Bob");

        System.out.println(table.getCollisionCount());
    }
}


