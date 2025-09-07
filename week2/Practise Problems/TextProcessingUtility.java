import java.util.Scanner;

public class TextProcessingUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSING UTILITY ===");
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        System.out.println("\n--- BASIC INFO ---");
        System.out.println("Original Text: \"" + text + "\"");
        System.out.println("Length: " + text.length());
        System.out.println("Trimmed: \"" + text.trim() + "\"");

        System.out.println("\n--- CASE CONVERSION ---");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());

        System.out.println("\n--- CHARACTER OPERATIONS ---");
        if (!text.isEmpty()) {
            System.out.println("First Character: " + text.charAt(0));
            System.out.println("Last Character: " + text.charAt(text.length() - 1));
        }

        System.out.println("\n--- WORD ANALYSIS ---");
        String[] words = text.trim().split("\\s+");
        System.out.println("Total Words: " + words.length);
        System.out.println("Words List:");
        for (String word : words) {
            System.out.println("- " + word);
        }

        System.out.println("\n--- STRING SEARCH ---");
        System.out.print("Enter a word to search: ");
        String searchWord = sc.nextLine();
        if (text.contains(searchWord)) {
            System.out.println("Found '" + searchWord + "' at index: " + text.indexOf(searchWord));
        } else {
            System.out.println("Word not found.");
        }

        System.out.println("\n--- REPLACE WORD ---");
        System.out.print("Enter word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();
        String replacedText = text.replace(oldWord, newWord);
        System.out.println("After Replacement: " + replacedText);

        System.out.println("\n--- COMPARISON ---");
        System.out.print("Enter another sentence for comparison: ");
        String another = sc.nextLine();
        System.out.println("Equals (case-sensitive): " + text.equals(another));
        System.out.println("Equals Ignore Case: " + text.equalsIgnoreCase(another));

        System.out.println("\n--- BLANK & EMPTY CHECK ---");
        System.out.println("Is input empty? " + text.isEmpty());
        System.out.println("Is input blank? " + text.isBlank());

        System.out.println("\n=== PROCESSING COMPLETE ===");
        sc.close();
    }
}
