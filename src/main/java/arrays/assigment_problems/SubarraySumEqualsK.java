package arrays.assigment_problems;

import java.util.HashMap;

/**
 * Week 4 - Category C - A4: Subarray Sum Equals K
 *
 * Counts how many contiguous subarrays sum to exactly k, using running prefix
 * sums plus a hash map of prefix-sum frequencies. The sum of a subarray ending
 * at the current index equals k whenever some earlier prefix sum equals
 * (runningSum - k). O(n) time, O(n) space.
 *
 * A sliding window does not work here because the array can contain negatives:
 * growing the window can lower the sum, so there is no monotonic signal telling
 * the window when to shrink.
 */
public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1); // the empty prefix has sum 0, seen once

        int runningSum = 0;
        int count = 0;

        for (int num : nums) {
            runningSum += num;
            // Every earlier prefix equal to (runningSum - k) marks a subarray summing to k.
            count += prefixCounts.getOrDefault(runningSum - k, 0);
            prefixCounts.put(runningSum, prefixCounts.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));  // 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0)); // 3
    }
}
