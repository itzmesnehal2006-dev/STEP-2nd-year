import java.util.Scanner;

public class ComprehensiveStringUtility {

    // === 1. Basic String Methods ===
    private static void basicMethods(String text) {
        System.out.println("\n--- BASIC STRING METHODS ---");
        System.out.println("Original: \"" + text + "\"");
        System.out.println("Length: " + text.length());
        System.out.println("Trimmed: \"" + text.trim() + "\"");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        if (!text.isEmpty()) {
            System.out.println("First char: " + text.charAt(0));
            System.out.println("Last char: " + text.charAt(text.length() - 1));
        }
        System.out.println("Contains 'Java': " + text.contains("Java"));
    }

    // === 2. String Comparison ===
    private static void compareStrings(String s1, String s2) {
        System.out.println("\n--- STRING COMPARISON ---");
        System.out.println("equals(): " + s1.equals(s2));
        System.out.println("equalsIgnoreCase(): " + s1.equalsIgnoreCase(s2));
        System.out.println("compareTo(): " + s1.compareTo(s2));
        System.out.println("compareToIgnoreCase(): " + s1.compareToIgnoreCase(s2));
        System.out.println("startsWith(\"He\"): " + s1.startsWith("He"));
        System.out.println("endsWith(\"lo\"): " + s1.endsWith("lo"));
        if (s1.length() >= 3 && s2.length() >= 3) {
            System.out.println("regionMatches(0, s2, 0, 3): " + s1.regionMatches(0, s2, 0, 3));
        }
    }

    // === 3. ASCII Manipulation ===
    private static void asciiOperations(char ch) {
        System.out.println("\n--- ASCII MANIPULATION ---");
        int ascii = (int) ch;
        System.out.println("Character: " + ch);
        System.out.println("ASCII Value: " + ascii);

        if (Character.isLetter(ch)) {
            if (Character.isUpperCase(ch)) {
                System.out.println("Lowercase conversion: " + (char) (ascii + 32));
            } else {
                System.out.println("Uppercase conversion: " + (char) (ascii - 32));
            }
        }

        System.out.println("Next char (ASCII+1): " + (char) (ascii + 1));
        System.out.println("Previous char (ASCII-1): " + (char) (ascii - 1));
    }

    // === 4. Performance Benchmark ===
    private static void performanceTest(int iterations) {
        System.out.println("\n--- PERFORMANCE TEST (" + iterations + " concatenations) ---");
        long startTime, endTime;

        // String
        startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "x";
        }
        endTime = System.nanoTime();
        System.out.println("String Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("x");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append("x");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    // === Main Menu ===
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== COMPREHENSIVE STRING UTILITY ===");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Basic String Methods");
            System.out.println("2. String Comparison");
            System.out.println("3. ASCII Manipulation");
            System.out.println("4. Performance Test");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a string: ");
                    String text = sc.nextLine();
                    basicMethods(text);
                }
                case 2 -> {
                    System.out.print("Enter first string: ");
                    String s1 = sc.nextLine();
                    System.out.print("Enter second string: ");
                    String s2 = sc.nextLine();
                    compareStrings(s1, s2);
                }
                case 3 -> {
                    System.out.print("Enter a character: ");
                    char ch = sc.next().charAt(0);
                    asciiOperations(ch);
                }
                case 4 -> {
                    System.out.print("Enter number of iterations: ");
                    int iters = sc.nextInt();
                    performanceTest(iters);
                }
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }

        sc.close();
    }
}
