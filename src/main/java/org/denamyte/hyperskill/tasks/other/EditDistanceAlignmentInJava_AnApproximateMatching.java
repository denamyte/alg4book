package org.denamyte.hyperskill.tasks.other;

import org.denamyte.hyperskill.algorithms.string.edit_distance_alignment.EditDistanceAlignmentApproximateMatching;

/**
 * Algorithm for approximate matching of a substring S in a string T
 */
public class EditDistanceAlignmentInJava_AnApproximateMatching {
    public static void main(String[] args) {
        var eda = new EditDistanceAlignmentApproximateMatching(3, 5);
        System.out.println(eda.calcAlignment("hello", "greenyellowblue"));
//        System.out.println(eda.calcAlignment("attacgggtcctacatgatgcgtggatatttatataaaaactctagtatt",
//                                             "qqqqqqq_atagtctgagctgactggggtatgtatagaagtctgct_qqqqqqqqqq"));
//        System.out.println(eda.calcAlignment("cab", "abacabad"));
    }
}
