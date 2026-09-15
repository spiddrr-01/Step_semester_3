package arrays_and_methods.assigment_problems;

import java.util.Arrays;

/**
 * Week 5 - Category C - Problem 1: Hackathon Score Curve Booster
 *
 * Adds a flat bonus to every score in place. The method returns nothing - an
 * array parameter refers to the same array the caller holds, so the change is
 * visible without any reassignment. The result is printed with Arrays.toString.
 */
public class HackathonScoreCurveBooster {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus; // mutates the caller's own array
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores)); // [80, 95, 70]
    }
}
