package strings.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 4: Masked Phone Number Formatter
 *
 * Validates a 10-digit phone number, then builds "XXXXXX" + the last 4 digits
 * with StringBuilder and inserts a "-" between the mask and those digits.
 */
public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");            // first 6 digits hidden
        masked.append(phone.substring(6));  // last 4 digits kept visible
        masked.insert(6, "-");              // readability separator

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210")); // XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));      // Invalid phone number
    }
}
