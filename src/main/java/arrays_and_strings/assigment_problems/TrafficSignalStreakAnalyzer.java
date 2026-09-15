package arrays_and_strings.assigment_problems;

/**
 * Week 1 - Problem 3: The Traffic Signal Streak Analyzer
 *
 * Scans a day's signal log (characters 'R', 'Y', 'G') and reports the longest
 * continuous streak of the same colour, tracking a running maximum.
 */
public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal readings to analyze.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLen = 1;

        char currentColor = signalLog.charAt(0);
        int currentLen = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentColor) {
                currentLen++;          // streak continues
            } else {
                currentColor = c;      // streak resets on a new colour
                currentLen = 1;
            }

            if (currentLen > longestLen) {
                longestLen = currentLen;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLen + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR"); // Longest Streak: 'G' repeated 3 times
        findLongestStreak("RRRRYYGG"); // Longest Streak: 'R' repeated 4 times
    }
}
