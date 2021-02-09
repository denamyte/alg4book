package org.denamyte.hyperskill.structures.hash_table;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A custom hash table with fixed size and linear probing hash collisions algorithm.
 * Source: <a href="https://hyperskill.org/learn/step/6945">Theory: Hash table in Java</a>
 */
public class CustomHashTable<T> {
    private final int size;
    private final TableEntry[] table;

    private final AtomicInteger collisionCounter = new AtomicInteger();

    public CustomHashTable(int size) {
        this.size = size;
        table = new TableEntry[size];
    }

    private int findEntryIndex(int key) {
        int hash = key % size;

        while (!(table[hash] == null || table[hash].getKey() == key)) {
            collisionCounter.incrementAndGet();
            hash = (hash + 1) % size;

            if (hash == key % size) {
                return -1;
            }
        }

        return hash;
    }

    public boolean put(int key, T value) {
        int idx = findEntryIndex(key);

        if (idx == -1) {
            return false;
        }

        table[idx] = new TableEntry(key, value);
        return true;
    }

    public T get(int key) {
        int idx = findEntryIndex(key);

        if (idx == -1 || table[idx] == null) {
            return null;
        }

        return (T) table[idx].getValue();
    }

    public int getCollisionCount() {
        return collisionCounter.get();
    }

    @Override
    public String toString() {
        StringBuilder tableStringBuilder = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                tableStringBuilder.append(i).append(": null");
            } else {
                tableStringBuilder.append(i).append(": key=").append(table[i].getKey())
                        .append(", value=").append(table[i].getValue());
            }

            if (i < table.length - 1) {
                tableStringBuilder.append("\n");
            }
        }

        return tableStringBuilder.toString();
    }
}

class TableEntry {
    private final int key;
    private final Object value;

    public TableEntry(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}

class Main {
    public static void main(String[] args) {
        CustomHashTable<String> table = new CustomHashTable<>(5);

        table.put(21, "John");
        table.put(33, "Tom");
        table.put(42, "Alice");
        table.put(10, "Mike");
        table.put(54, "Kate");

        System.out.println(table);
    }
}