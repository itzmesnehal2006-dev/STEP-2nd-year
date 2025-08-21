import java.util.Scanner;

public class AsciiManipulationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ASCII CHARACTER MANIPULATION ===");

        // Input a character
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        // Show ASCII value
        int ascii = (int) ch;
        System.out.println("\nCharacter: " + ch);
        System.out.println("ASCII Value: " + ascii);

        // Convert case if it's alphabet
        if (Character.isLetter(ch)) {
            if (Character.isUpperCase(ch)) {
                char lower = (char) (ascii + 32);  // 'A'(65) → 'a'(97)
                System.out.println("Lowercase: " + lower);
            } else {
                char upper = (char) (ascii - 32);  // 'a'(97) → 'A'(65)
                System.out.println("Uppercase: " + upper);
            }
        }

        // Shift character by 1
        char nextChar = (char) (ascii + 1);
        char prevChar = (char) (ascii - 1);
        System.out.println("Next Character (ASCII+1): " + nextChar);
        System.out.println("Previous Character (ASCII-1): " + prevChar);

        // Demonstrate digits
        System.out.println("\n--- DIGIT CONVERSION ---");
        System.out.print("Enter a digit character (0-9): ");
        char digitCh = sc.next().charAt(0);
        int digitAscii = (int) digitCh;
        int numericValue = digitCh - '0'; // Convert char → int
        System.out.println("Character: " + digitCh);
        System.out.println("ASCII Value: " + digitAscii);
        System.out.println("Numeric Value: " + numericValue);

        // Display ASCII table (A-Z)
        System.out.println("\n--- ASCII TABLE (A-Z) ---");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println(c + " : " + (int) c);
        }

        sc.close();
    }
}
