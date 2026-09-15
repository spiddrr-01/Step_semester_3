package arrays.assigment_problems;

import java.util.Arrays;

/**
 * Week 4 - Category C - A3: 3Sum
 *
 * Returns every unique triplet that sums to zero. The array is sorted first,
 * then for each element a two-pointer scan closes in from both ends, skipping
 * duplicate values at every level so no triplet is reported twice. O(n^2) time.
 *
 * To stay within "arrays only" (no ArrayList), the triplets are gathered in two
 * passes over the same logic: the first pass counts how many there are, the
 * second fills an exactly-sized int[][].
 */
public class ThreeSum {

    static int[][] threeSum(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted); // sorting is the allowed setup step
        int n = sorted.length;

        int count = collectTriplets(sorted, n, null); // pass 1: count only
        int[][] result = new int[count][3];
        collectTriplets(sorted, n, result);           // pass 2: fill
        return result;
    }

    /**
     * Runs the two-pointer scan. When {@code out} is null it only counts the
     * triplets; otherwise it writes each triplet into {@code out}. Returns the
     * number of triplets found.
     */
    private static int collectTriplets(int[] a, int n, int[][] out) {
        int idx = 0;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                continue; // skip a repeated value in the "first element" slot
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = a[i] + a[left] + a[right];
                if (sum == 0) {
                    if (out != null) {
                        out[idx][0] = a[i];
                        out[idx][1] = a[left];
                        out[idx][2] = a[right];
                    }
                    idx++;
                    left++;
                    right--;
                    // Skip duplicate values for the second and third elements.
                    while (left < right && a[left] == a[left - 1]) {
                        left++;
                    }
                    while (left < right && a[right] == a[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;  // need a larger sum
                } else {
                    right--; // need a smaller sum
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1, 0, 1, 2, -1, -4}))); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(Arrays.deepToString(threeSum(new int[]{0, 0, 0})));             // [[0, 0, 0]]
    }
}
