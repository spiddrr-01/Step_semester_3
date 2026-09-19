package strings.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 5: Bank Transaction Reference Generator &amp; Validator
 *
 * A valid reference is exactly 14 characters: 3 letters (bank code) + 6 digits
 * (date, ddMMyy) + 5 digits (sequence). normalizeReference() trims stray spaces
 * and uppercases only the bank code; validateAndFormat() then checks it and
 * either builds the display line or reports the specific failure reason.
 * No regex - Character.isLetter()/isDigit() in a loop.
 */
public class BankTransactionReferenceValidator {

    /** Trims whitespace, then uppercases just the 3-character bank code. */
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed; // too short to have a bank code; validation will report it
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3); // 11 characters: ddMMyy + 5-digit sequence
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: date and sequence must be digits only";
            }
        }

        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        StringBuilder display = new StringBuilder();
        display.append("[").append(bankCode).append("] ")
                .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
                .append(" | SEQ: ").append(sequence);
        return display.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference("  hdf03022600042  "))); // [HDF] DATE: 03/02/26 | SEQ: 00042
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));     // Invalid: bank code must be 3 letters
    }
}
