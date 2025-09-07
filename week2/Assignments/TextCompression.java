import java.util.*;

public class TextCompression {

    // Method to count character frequencies without HashMap
    public static Object[] countFrequencies(String text) {
        char[] chars = new char[text.length()];
        int[] freq = new int[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean found = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (chars[j] == c) {
                    freq[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                chars[uniqueCount] = c;
                freq[uniqueCount] = 1;
                uniqueCount++;
            }
        }

        char[] finalChars = Arrays.copyOf(chars, uniqueCount);
        int[] finalFreq = Arrays.copyOf(freq, uniqueCount);

        return new Object[]{finalChars, finalFreq};
    }

    // Method to create compression codes
    public static String[][] createCodes(char[] chars, int[] freq) {
        int n = chars.length;
        String[][] mapping = new String[n][2];

        // Sort by frequency (simple bubble sort for clarity)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (freq[j] < freq[j + 1]) {
                    int tempF = freq[j];
                    freq[j] = freq[j + 1];
                    freq[j + 1] = tempF;

                    char tempC = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = tempC;
                }
            }
        }

        // Assign shorter codes to frequent chars
        String symbols = "!@#$%^&*0123456789abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < n; i++) {
            mapping[i][0] = String.valueOf(chars[i]);
            mapping[i][1] = String.valueOf(symbols.charAt(i % symbols.length()));
        }
        return mapping;
    }

    // Compress text
    public static String compressText(String text, String[][] mapping) {
        StringBuilder compressed = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (String[] map : mapping) {
                if (map[0].charAt(0) == c) {
                    compressed.append(map[1]);
                    break;
                }
            }
        }
        return compressed.toString();
    }

    // Decompress text
    public static String decompressText(String compressed, String[][] mapping) {
        StringBuilder decompressed = new StringBuilder();

        for (int i = 0; i < compressed.length(); i++) {
            char c = compressed.charAt(i);
            for (String[] map : mapping) {
                if (map[1].charAt(0) == c) {
                    decompressed.append(map[0]);
                    break;
                }
            }
        }
        return decompressed.toString();
    }

    // Display analysis
    public static void displayAnalysis(String text, String compressed, String decompressed,
                                       char[] chars, int[] freq, String[][] mapping) {
        System.out.println("=== CHARACTER FREQUENCY TABLE ===");
        System.out.printf("%-10s %-10s%n", "Char", "Frequency");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%-10s %-10d%n", chars[i], freq[i]);
        }

        System.out.println("\n=== COMPRESSION MAPPING ===");
        System.out.printf("%-10s %-10s%n", "Char", "Code");
        for (String[] map : mapping) {
            System.out.printf("%-10s %-10s%n", map[0], map[1]);
        }

        System.out.println("\n=== TEXT COMPRESSION ANALYSIS ===");
        System.out.println("Original Text:   " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed:    " + decompressed);

        int originalSize = text.length();
        int compressedSize = compressed.length();
        double efficiency = ((double)(originalSize - compressedSize) / originalSize) * 100;

        System.out.println("\nOriginal Size: " + originalSize);
        System.out.println("Compressed Size: " + compressedSize);
        System.out.printf("Compression Efficiency: %.2f%%\n", efficiency);
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to compress: ");
        String text = sc.nextLine();

        // Step 1: Frequency count
        Object[] result = countFrequencies(text);
        char[] chars = (char[]) result[0];
        int[] freq = (int[]) result[1];

        // Step 2: Create mapping
        String[][] mapping = createCodes(chars, freq);

        // Step 3: Compress
        String compressed = compressText(text, mapping);

        // Step 4: Decompress
        String decompressed = decompressText(compressed, mapping);

        // Step 5: Display
        displayAnalysis(text, compressed, decompressed, chars, freq, mapping);

        sc.close();
    }
}
