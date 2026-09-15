package arrays.assigment_problems;

/**
 * Week 4 - Category C - A5: Find Minimum in Rotated Sorted Array
 *
 * Finds the minimum of a distinct, ascending array that was rotated at an
 * unknown pivot, using a modified binary search. At each step the middle
 * element is compared with the rightmost element to decide which half must
 * contain the minimum. O(log n) time. The already-sorted (no rotation) case
 * falls out naturally.
 */
public class FindMinimumInRotatedSortedArray {

    static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                // The rotation point (and the minimum) is to the right of mid.
                low = mid + 1;
            } else {
                // nums[mid] <= nums[high]: the minimum is at mid or to its left.
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));       // 1
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(findMin(new int[]{11, 13, 15, 17}));      // 11
    }
}
