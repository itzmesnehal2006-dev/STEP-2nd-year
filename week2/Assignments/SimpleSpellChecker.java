import java.util.*;

public class SimpleSpellChecker {

    // Method to split sentence into words without using split()
    public static String[] splitSentence(String sentence) {
        ArrayList<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ' || ch == '.' || ch == ',' || ch == '!' || ch == '?') {
                if (start < i) {
                    words.add(sentence.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < sentence.length()) {
            words.add(sentence.substring(start));
        }
        return words.toArray(new String[0]);
    }

    // Method to calculate string distance (basic edit distance approximation)
    public static int stringDistance(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        // If same length → count character differences
        if (lenA == lenB) {
            int diff = 0;
            for (int i = 0; i < lenA; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    diff++;
                }
            }
            return diff;
        } else {
            // Distance = length difference + mismatched chars in common length
            int minLen = Math.min(lenA, lenB);
            int diff = Math.abs(lenA - lenB);
            for (int i = 0; i < minLen; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    diff++;
                }
            }
            return diff;
        }
    }

    // Find closest matching word from dictionary
    public static String findClosestWord(String word, String[] dictionary) {
        int minDistance = Integer.MAX_VALUE;
        String closest = word; // default → assume correct
        for (String dictWord : dictionary) {
            int distance = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (distance < minDistance) {
                minDistance = distance;
                closest = dictWord;
            }
        }
        // If word is already correct
        if (minDistance == 0) return word;

        // Accept correction only if distance ≤ 2
        return (minDistance <= 2) ? closest : word;
    }

    // Display results in table format
    public static void displayResults(String[] words, String[] dictionary) {
        System.out.printf("%-15s %-15s %-10s %-15s%n", "Original", "Suggestion", "Distance", "Status");
        System.out.println("---------------------------------------------------------------");
        for (String word : words) {
            String suggestion = findClosestWord(word, dictionary);
            int distance = stringDistance(word.toLowerCase(), suggestion.toLowerCase());
            String status = (distance == 0) ? "Correct" : "Misspelled";
            System.out.printf("%-15s %-15s %-10d %-15s%n", word, suggestion, distance, status);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dictionary of correct words
        String[] dictionary = {"hello", "world", "java", "program", "checker", "simple", "spell", "example"};

        // Input sentence
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Split into words
        String[] words = splitSentence(sentence);

        // Display results
        displayResults(words, dictionary);

        sc.close();
    }
}
