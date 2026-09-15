package arrays_and_methods.assigment_problems;

import java.util.Arrays;
import java.util.Locale;

/**
 * Week 5 - Category C - Problem 5: Placement Drive Shortlisting & Ranking Engine
 *
 * Integrates arrays, method overloading, static methods, the standard library
 * (Arrays.sort), constructors and encapsulation.
 *
 * Eligibility:
 *   - a strong CGPA alone qualifies (CGPA >= 7.5), OR
 *   - a borderline CGPA (>= 6.5) still qualifies when backed by a good coding
 *     score (>= 60).
 *
 * Ranking:
 *   - composite score = CGPA * 10 + codingScore * 0.5
 *   - Candidate implements Comparable so a plain Arrays.sort ranks the
 *     shortlist by composite score, descending, with no hand-written sort.
 */
public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        /** Ranking metric: CGPA weighted x10, coding score weighted x0.5. */
        private double composite() {
            return cgpa * 10 + codingScore * 0.5;
        }

        /** Quick filter: a strong CGPA on its own is enough. */
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        /** Borderline filter: a decent CGPA plus a genuinely good coding score. */
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        /** Rank by composite score, descending, so Arrays.sort alone orders the podium. */
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.composite(), this.composite());
        }

        static String shortlistAndRank(Candidate[] candidates) {
            // Pass 1: count who qualifies (CGPA-only OR the combined borderline check).
            int qualified = 0;
            for (Candidate c : candidates) {
                if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                    qualified++;
                }
            }

            // Pass 2: collect exactly the qualifying candidates.
            Candidate[] shortlisted = new Candidate[qualified];
            int idx = 0;
            for (Candidate c : candidates) {
                if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                    shortlisted[idx++] = c;
                }
            }

            Arrays.sort(shortlisted); // uses compareTo - no manual sort loop

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < shortlisted.length; i++) {
                if (i > 0) {
                    sb.append(" | ");
                }
                sb.append(String.format(Locale.US, "%d. %s (%.1f)",
                        i + 1, shortlisted[i].name, shortlisted[i].composite()));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        // 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
        System.out.println(Candidate.shortlistAndRank(candidates));
    }
}
