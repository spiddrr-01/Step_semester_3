package arrays.assigment_problems;

/**
 * Week 4 - Category C - A2: Maximum Subarray (Kadane's algorithm)
 *
 * Finds the largest sum of any contiguous subarray (at least one element).
 * At each element we decide whether to extend the current run or restart from
 * the element itself. O(n) time, O(1) space.
 *
 * Follow-up (divide and conquer, O(n log n)): split the array in half; the best
 * subarray lies entirely in the left half, entirely in the right half, or
 * crosses the midpoint. Solve the two halves recursively, compute the best
 * crossing sum by expanding outward from the middle, and take the maximum of
 * the three.
 */
public class MaximumSubarray {

    static int maxSubArray(int[] nums) {
        int best = nums[0];    // best subarray sum found anywhere so far
        int current = nums[0]; // best subarray sum ending exactly at the current index

        for (int i = 1; i < nums.length; i++) {
            // Extend the running subarray, or abandon it and start fresh at nums[i].
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{-3, -1, -2}));                    // -1
    }
}
