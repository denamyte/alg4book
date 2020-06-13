package org.denamyte.algs4.code;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class BinarySearchNoDuplicates {

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);
        whitelist = removeDuplicates(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexOf(whitelist, key) == -1)
                StdOut.println(key);
        }
    }

    /**
     * Returns a new array without
     * @param array A sorted array
     * @return A new array without duplicates
     */
    public static int[] removeDuplicates(int[] array) {
        if (ArrayUtils.getLength(array) == 0)
            return array;
        int[] newArray = new int[array.length];
        newArray[0] = array[0];
        int newIndex = 0;  // intended to compare newArray[newIndex] with array[i]
        for (int i = 1; i < array.length; i++) {
            if (newArray[newIndex] != array[i]) {
                newIndex++;
                newArray[newIndex] = array[i];
            }
        }
        return Arrays.copyOf(newArray, newIndex + 1);
    }
}
