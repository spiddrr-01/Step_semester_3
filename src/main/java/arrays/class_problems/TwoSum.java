package arrays.class_problems;

import java.util.Arrays;

/**
 * Week 4 - Category C - L1: Two Sum
 *
 * Checks every pair of different positions with two nested loops and returns
 * the first pair of indices whose values add up to the target.
 */
public class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // j starts after i, so no element is reused
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // the brief guarantees one valid pair exists
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));      // [1, 2]
    }
}
