package Assistment_7;

import java.util.Arrays;

public class Lab7Test {
    public static void main(String[] args) {
        int[] arr0 = {4, 7, 5, 2, 6, 1};
        int[] arr1 = {3, 6, 5, 1, 4};
        int[] arr2 = {5, 3, 1, 2, 4};
        int[] arr3 = {5, 3, 1, 2, 4};
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr5 = {4, 5, 2, 1, 3};
        int[] arr6 = {1, 2, 2, 3, 4, 4, 4, 5};
        int[] arr7 = {2, 2, 2, 2, 2};
        int[] arr8 = {1, 2, 3, 4, 5, 6};
        int[] arr9 = {9, 2, 4, 8, 9, 4, 3, 2, 8, 1, 2, 7, 2, 5};

        // Problem 1 - Find missing number
        System.out.println(Lab7.findMissing(arr1)); // expected output: 2
        System.out.println(Lab7.findMissing(arr0)); // expected output: 3

        // Problem 2 - Counting sort
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        Lab7.countingSort(arr2, 5);
        System.out.println(Arrays.toString(arr2)); // expected output: [1, 2, 3, 4, 5]
        Lab7.countingSort(arr9, 14);
        System.out.println(Arrays.toString(arr9)); // expected output: [1, 2, 2, 2, 2, 3, 4, 4, 5, 7, 8, 8, 9, 9]

        // Problem 3 - Find k-th smallest element
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println(Lab7.findKthSmallest(arr3, 2)); // expected output: 2
        System.out.println(Lab7.findKthSmallest(arr4, 4)); // expected output: 4
        System.out.println(Lab7.findKthSmallest(arr5, 3)); // expected output: 3
        System.out.println(Lab7.findKthSmallest(arr6, 6)); // expected output: 4
        System.out.println(Lab7.findKthSmallest(arr7, 1)); // expected output: 2
        System.out.println(Lab7.findKthSmallest(arr8, 7)); // expected output: 7

        // Problem 4 - Find median
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println(Lab7.findMedian(arr3)); // expected output: 3
        System.out.println(Lab7.findMedian(arr4)); // expected output: 4
        System.out.println(Lab7.findMedian(arr5)); // expected output: 3
        System.out.println(Lab7.findMedian(arr6)); // expected output: 3
        System.out.println(Lab7.findMedian(arr7)); // expected output: 2
        System.out.println(Lab7.findMedian(arr8)); // expected output: 3
    }
}
