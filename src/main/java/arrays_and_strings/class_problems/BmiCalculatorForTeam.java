package arrays_and_strings.class_problems;

import java.util.Locale;

/**
 * Day 1 Live-Coding Session - Problem 3: BMI Calculator for a Team
 *
 * Computes BMI = weight / (height * height) for a team held in parallel arrays,
 * classifies each person's status, and prints the wellness report as a table.
 */
public class BmiCalculatorForTeam {

    /** Underweight &lt; 18.5 | Normal 18.5-24.9 | Overweight 25-29.9 | Obese &gt;= 30. */
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf(Locale.US, "%-7s | %-10s | %-11s | %-6s | %s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf(Locale.US, "%-7d | %-10.2f | %-11.1f | %-6.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.68, 1.72};
        double[] weights = {70, 90, 95, 50, 68};
        printWellnessReport(heights, weights);
        // Person 1 -> BMI: 22.86 | Normal      Person 2 -> BMI: 35.16 | Obese
    }
}
