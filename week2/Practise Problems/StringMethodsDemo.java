public class StringMethodsDemo {
    public static void main(String[] args) {
        String text = "   Java Programming is Powerful and Popular!   ";

        System.out.println("=== ORIGINAL STRING ===");
        System.out.println("Text: \"" + text + "\"");
        System.out.println("Length: " + text.length());

        // 1. Trim leading and trailing spaces
        String trimmed = text.trim();
        System.out.println("\nTrimmed: \"" + trimmed + "\"");

        // 2. Convert to uppercase & lowercase
        System.out.println("Uppercase: " + trimmed.toUpperCase());
        System.out.println("Lowercase: " + trimmed.toLowerCase());

        // 3. Substring
        System.out.println("Substring (0-4): " + trimmed.substring(0, 4));

        // 4. Character at index
        System.out.println("Character at index 5: " + trimmed.charAt(5));

        // 5. Contains & startsWith & endsWith
        System.out.println("Contains 'Powerful': " + trimmed.contains("Powerful"));
        System.out.println("Starts with 'Java': " + trimmed.startsWith("Java"));
        System.out.println("Ends with 'Popular!': " + trimmed.endsWith("Popular!"));

        // 6. Replace
        String replaced = trimmed.replace("Powerful", "Strong");
        System.out.println("Replaced 'Powerful' → 'Strong': " + replaced);

        // 7. Index of substring
        System.out.println("Index of 'Programming': " + trimmed.indexOf("Programming"));

        // 8. Split into words
        String[] words = trimmed.split(" ");
        System.out.println("\nWords in the sentence:");
        for (String word : words) {
            System.out.println("- " + word);
        }

        // 9. Compare strings
        String str1 = "Java";
        String str2 = "java";
        System.out.println("\nEquals (case-sensitive): " + str1.equals(str2));
        System.out.println("Equals Ignore Case: " + str1.equalsIgnoreCase(str2));

        // 10. String is empty or blank
        String emptyStr = "";
        String blankStr = "   ";
        System.out.println("\nIs empty string empty? " + emptyStr.isEmpty());
        System.out.println("Is blank string blank? " + blankStr.isBlank());
    }
}
