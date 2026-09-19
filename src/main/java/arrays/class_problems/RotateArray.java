package arrays.class_problems;

import java.util.Arrays;

/**
 * Week 4 - Category C - L5: Rotate Array
 *
 * Rotates right by k. k is first reduced with k % length (rotating by a full
 * length changes nothing), then each element is placed straight into its
 * final position in a new array via newArray[(i + k) % length] = nums[i].
 */
public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // a full rotation has no visible effect

        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3))); // [5, 6, 7, 1, 2, 3, 4]
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));                // [2, 1]
    }
}
