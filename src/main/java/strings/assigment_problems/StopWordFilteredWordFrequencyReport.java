package strings.assigment_problems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Week 2 - Problem 5: Stop-Word-Filtered Word Frequency Report
 *
 * Lowercases the feedback, strips periods/commas, splits on whitespace, skips
 * a fixed stop-word list, counts the rest, and prints them sorted by count
 * descending. Ties keep the order the words first appeared in (a LinkedHashMap
 * plus a stable sort achieves that, matching the sample exactly).
 */
public class StopWordFilteredWordFrequencyReport {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private static boolean isStopWord(String word) {
        for (String stop : STOP_WORDS) {
            if (stop.equals(word)) {
                return true;
            }
        }
        return false;
    }

    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase()
                .replace(",", "")
                .replace(".", "");

        String[] words = cleaned.trim().split("\\s+");

        // LinkedHashMap keeps first-seen order, which the stable sort below preserves for ties.
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        Map.Entry<String, Integer>[] entries = counts.entrySet().toArray(new Map.Entry[0]);
        Arrays.sort(entries, (a, b) -> b.getValue() - a.getValue()); // descending by count, stable

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
        // great: 2
        // mentor: 1
        // session: 1
        // clear: 1
    }
}
