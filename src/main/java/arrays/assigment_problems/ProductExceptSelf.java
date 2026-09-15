package arrays.assigment_problems;

import java.util.Arrays;

/**
 * Week 4 - Category C - A1: Product of Array Except Self
 *
 * answer[i] = product of every element except nums[i], using no division.
 * Two passes: a forward pass for the running product of everything to the left,
 * a backward pass for everything to the right. O(n) time, O(1) extra space
 * beyond the output array.
 */
public class ProductExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: answer[i] holds the product of everything to the LEFT of i.
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: fold in the running product of everything to the RIGHT of i.
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));      // [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // [0, 0, 9, 0, 0]
    }
}
