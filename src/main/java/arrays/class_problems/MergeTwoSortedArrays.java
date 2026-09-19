package arrays.class_problems;

import java.util.Arrays;

/**
 * Week 4 - Category C - L4: Merge Two Sorted Arrays
 *
 * Two-pointer merge: repeatedly copy the smaller of the two current elements
 * into the result, then drain whichever array still has elements left. No
 * re-sorting of the combined data.
 */
public class MergeTwoSortedArrays {

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0; // pointer into arr1
        int j = 0; // pointer into arr2
        int k = 0; // write position in merged

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // One array is now exhausted; copy whatever remains from the other.
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6}))); // [1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{}, new int[]{1, 2, 3})));        // [1, 2, 3]
    }
}
