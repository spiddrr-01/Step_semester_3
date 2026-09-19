package strings.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 1: Vowel &amp; Consonant Counter
 *
 * Walks the text with charAt() and counts vowels and consonants separately,
 * case-insensitively, ignoring spaces.
 */
public class VowelConsonantCounter {

    static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));

            if (!Character.isLetter(c)) {
                continue; // skips spaces (and any stray punctuation)
            }

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming"); // Vowels: 5 | Consonants: 10
    }
}
