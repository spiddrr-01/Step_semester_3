package arrays_and_methods.class_problems;

/**
 * Week 5 - Category C - Problem 4: Hackathon Seating Grid Optimizer
 *
 * Classifies every row of a (possibly jagged) grid as a "Quiet Zone" (average
 * below the threshold) or a "Buzzing Zone" (average at or above it). A small
 * reusable helper computes one row's average and nothing else; the main method
 * is the only place that decides the zone.
 */
public class HackathonSeatingGridOptimizer {

    /** Sole responsibility: return the average of one row. */
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int r = 0; r < seatingScores.length; r++) {
            double average = rowAverage(seatingScores[r]); // helper used once per row
            String zone = (average < threshold) ? "Quiet Zone" : "Buzzing Zone";

            if (r > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(r).append(": ").append(zone);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seating = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };
        System.out.println(classifyRows(seating, 60)); // Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}
