package arrays_and_strings.class_problems;

/**
 * Day 1 Live-Coding Session - Problem 5: Reverse Customer Name
 *
 * Returns a reversed copy of the customer's name while leaving the original
 * string untouched (Strings are immutable in Java, so the original is safe).
 */
public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = characters.length - 1; i >= 0; i--) {
            reversed.append(characters[i]);
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String name = "Sunil";
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverseCustomerName(name));
        // Original Name: Sunil / Reversed Name: linuS
    }
}
