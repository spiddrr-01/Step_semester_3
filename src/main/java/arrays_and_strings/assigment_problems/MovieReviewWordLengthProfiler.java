package arrays_and_strings.assigment_problems;

/**
 * Week 1 - Problem 5: The Movie Review Word Length Profiler
 *
 * Splits a review into words and classifies each as Short (1-4 letters),
 * Medium (5-8 letters) or Long (9+ letters), then prints the counts.
 */
public class MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        // Split on runs of whitespace; trim first so a leading/trailing space
        // does not produce an empty word.
        String[] words = review.trim().split("\\s+");
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            int len = word.length();
            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling"); // Short: 3 | Medium: 1 | Long: 3
    }
}
