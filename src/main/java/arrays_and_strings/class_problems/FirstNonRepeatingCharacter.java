package arrays_and_strings.class_problems;

/**
 * Day 1 Live-Coding Session - Problem 4: First Non-Repeating Character
 *
 * Scans left to right and returns the first character whose frequency in the
 * whole string is exactly 1. Returns '\0' as a sentinel when every character
 * repeats, which the caller turns into a clear message.
 */
public class FirstNonRepeatingCharacter {

    static char findFirstNonRepeatingChar(String text) {
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            int frequency = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == current) {
                    frequency++;
                }
            }

            if (frequency == 1) {
                return current; // early exit on the first unique character
            }
        }
        return '\0'; // sentinel: no non-repeating character exists
    }

    static void report(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        report("swiss");  // First Non-Repeating Character: 'w'
        report("aabbcc"); // No Non-Repeating Character Found
    }
}
