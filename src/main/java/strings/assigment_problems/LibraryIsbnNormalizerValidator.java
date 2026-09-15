package strings.assigment_problems;

/**
 * Week 2 - Problem 4: Library ISBN Normalizer &amp; Validator
 *
 * A valid code is exactly 13 characters: 3 letters (publisher code) + 4 digit
 * year + 6 digit catalog number. normalizeCode() trims stray spaces and
 * uppercases only the first 3 characters; validateAndFormat() then checks the
 * normalized code and either builds a display line or reports the specific
 * reason it failed. No regex - Character.isLetter()/isDigit() in a loop.
 */
public class LibraryIsbnNormalizerValidator {

    /** Trims whitespace, then uppercases just the 3-character publisher code. */
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed; // too short to even have a publisher code; let validation report it
        }
        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return publisherCode + rest;
    }

    /** Validates a normalized code and either formats it or explains why it failed. */
    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);
        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = code.substring(3); // 10 characters: 4-digit year + 6-digit catalog
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: year and catalog number must be digits only";
            }
        }

        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] ")
                .append("YEAR: ").append(year).append(" | ")
                .append("CATALOG: ").append(catalog);
        return display.toString();
    }

    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1)); // [PEN] YEAR: 2026 | CATALOG: 004251

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2)); // Invalid: publisher code must be 3 letters
    }
}
