package arrays.class_problems;

/**
 * Week 4 - Category C - L3: Contains Duplicate
 *
 * Compares every element against every later element with nested loops and
 * exits early the moment two different positions hold the same value.
 */
public class ContainsDuplicate {

    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // early exit - one match is enough
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1})); // true
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4})); // false
    }
}
