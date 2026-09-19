package arrays_and_strings.class_problems;

/**
 * Day 1 Live-Coding Session - Problem 2: Palindrome Checker (3 Approaches)
 *
 * Verifies the same text three independent ways - iterative two-pointer,
 * recursion, and character-array reversal - and prints all three results so
 * they can be confirmed to agree.
 */
public class PalindromeChecker {

    /** Compare characters from both ends moving inward. */
    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /** Compare first and last characters, then recurse on the shrinking middle. */
    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true; // base case: empty or single character
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /** Reverse a char[] copy and compare it against the original. */
    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(original).equals(new String(reversed));
    }

    private static String label(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    static void report(String text) {
        System.out.println("Iterative: " + label(isPalindromeIterative(text))
                + " | Recursive: " + label(isPalindromeRecursive(text))
                + " | Array Reversal: " + label(isPalindromeArrayReversal(text)));
    }

    public static void main(String[] args) {
        report("madam"); // all three: Palindrome
        report("hello"); // all three: Not Palindrome
    }
}
