package strings.assigment_problems;

/**
 * Week 2 - Problem 2: Word Reversal Encoder
 *
 * Reverses every word in a sentence individually while keeping word order,
 * e.g. "hello club" -> "olleh bulc". Splits on single spaces, reverses each
 * word with a loop + StringBuilder, then joins the results back with spaces.
 */
public class WordReversalEncoder {

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Build this word's reverse one character at a time.
            StringBuilder reversedWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            if (i > 0) {
                result.append(" ");
            }
            result.append(reversedWord);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club")); // olleh bulc
    }
}
