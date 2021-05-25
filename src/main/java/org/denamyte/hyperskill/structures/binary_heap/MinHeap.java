package org.denamyte.hyperskill.structures.binary_heap;

import java.util.NoSuchElementException;
import java.util.Random;

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxsize;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (2 * pos == size) {
            if (heap[pos] > heap[2 * pos]) {
                swap(pos, 2 * pos);
                minHeapify(2 * pos);
            }
            return;
        }

        if (2 * pos <= size) {
            if (heap[pos] > heap[2 * pos] || heap[pos] > heap[2 * pos + 1]) {
                if (heap[2 * pos] < heap[2 * pos + 1]) {
                    swap(pos, 2 * pos);
                    minHeapify(2 * pos);
                }
                else {
                    swap(pos, 2 * pos + 1);
                    minHeapify(2 * pos + 1);
                }
            }
        }
    }

    public void insert(int element) {
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[current / 2]) {
            swap(current, current / 2);
            current = current / 2;
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        int popped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return popped;
    }
}

class TestDrive {
    public static void main(String[] args) {
        Random rnd = new Random();
        final int size = 10;
        final int maxInt = 30;
        MinHeap heap = new MinHeap(10);
        System.out.println("\nAdding random elements: ");
        for (int i = 0; i < size; i++) {
            final int next = rnd.nextInt(maxInt + 1);
            System.out.printf("%d ", next);
            heap.insert(next);
        }

        System.out.println("\nExtracting min: ");

        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", heap.extractMin());
        }
    }
}
