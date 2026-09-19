package strings.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 3: File Extension Validator
 *
 * Extracts the extension after the last '.' and checks it case-insensitively
 * against the accepted list (pdf, docx, zip).
 */
public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    static String validateFileExtension(String filename) {
        int lastDot = filename.lastIndexOf('.');

        // No dot at all, or nothing after it, means there is no usable extension.
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDot + 1);
        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (accepted.equalsIgnoreCase(extension)) {
                return "Accepted";
            }
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF")); // Accepted
        System.out.println(validateFileExtension("notes.txt"));       // Rejected — invalid file type
    }
}
