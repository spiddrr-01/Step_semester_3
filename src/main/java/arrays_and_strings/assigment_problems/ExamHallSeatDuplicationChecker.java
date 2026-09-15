package arrays_and_strings.assigment_problems;

/**
 * Week 1 - Problem 1: The Exam Hall Seat Duplication Checker
 *
 * Scans an array of assigned seat numbers and flags any seat given to two
 * different students. Arrays and nested loops only - no Collections class.
 */
public class ExamHallSeatDuplicationChecker {

    /**
     * Compares every seat number against every other one and prints any
     * duplicates found. Prints a confirmation message when there are none.
     */
    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean anyDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            // Skip this value if an earlier position already reported it,
            // so the same duplicated seat is not printed more than once.
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }

            // Look ahead for another copy of this seat number.
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    anyDuplicate = true;
                    break;
                }
            }
        }

        if (!anyDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105}); // Duplicate Seat Number Found: 102
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105}); // No Duplicate Seats Found
    }
}
