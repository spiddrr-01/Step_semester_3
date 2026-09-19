package arrays_and_methods.class_problems;

import java.util.Arrays;

/**
 * Week 5 - Category C - Problem 3: Top-3 Podium Finder
 *
 * Finds the top three scores in a single left-to-right pass (no sorting).
 * Three running variables - first, second, third - shift in order whenever a
 * new score outranks one of them. Ties are preserved: a second copy of the top
 * score slots into second place, so {..90..90..} yields two 90s on the podium.
 * Returned in descending order.
 */
public class TopThreePodiumFinder {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }
        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTopThreeScores(new int[]{45, 82, 79, 90, 33, 90, 61}))); // [90, 90, 82]
    }
}
