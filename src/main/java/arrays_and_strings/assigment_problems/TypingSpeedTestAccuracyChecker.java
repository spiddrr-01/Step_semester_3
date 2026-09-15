package arrays_and_strings.assigment_problems;

import java.util.Locale;

/**
 * Week 1 - Problem 2: The Typing Speed Test Accuracy Checker
 *
 * Compares a typed attempt against the original passage character by character,
 * reporting the match accuracy and the position of the first mismatch.
 */
public class TypingSpeedTestAccuracyChecker {

    /**
     * Both strings are expected to be the same length. Counts position-wise
     * matches, computes the accuracy percentage and reports the first mismatch
     * (positions are 1-based in the output).
     */
    static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatch = -1; // 0-based index of the first differing character

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / total;

        if (firstMismatch == -1) {
            System.out.printf(Locale.US,
                    "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, total, accuracy);
        } else {
            System.out.printf(Locale.US,
                    "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, total, accuracy, firstMismatch + 1,
                    original.charAt(firstMismatch), typed.charAt(firstMismatch));
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
