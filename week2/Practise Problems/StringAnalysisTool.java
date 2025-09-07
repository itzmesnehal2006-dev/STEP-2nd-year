import java.util.Scanner;

public class StringAnalysisTool {

    // Compare two strings using different methods
    private static void compareStrings(String s1, String s2) {
        System.out.println("\n=== STRING COMPARISON ===");
        System.out.println("String 1: \"" + s1 + "\"");
        System.out.println("String 2: \"" + s2 + "\"");

        System.out.println("equals(): " + s1.equals(s2));
        System.out.println("equalsIgnoreCase(): " + s1.equalsIgnoreCase(s2));
        System.out.println("compareTo(): " + s1.compareTo(s2));
        System.out.println("compareToIgnoreCase(): " + s1.compareToIgnoreCase(s2));

        if (s1.length() >= 3 && s2.length() >= 3) {
            System.out.println("regionMatches(0, s2, 0, 3): " + s1.regionMatches(0, s2, 0, 3));
        }

        System.out.println("contains(): " + s1.contains(s2));
        System.out.println("startsWith(): " + s1.startsWith(s2));
        System.out.println("endsWith(): " + s1.endsWith(s2));
    }

    // Performance test for concatenation
    private static void performanceTest(int iterations) {
        System.out.println("\n=== PERFORMANCE TEST (" + iterations + " concatenations) ===");
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== COMPREHENSIVE STRING ANALYSIS TOOL ===");

        // Input strings
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        // Run comparison
        compareStrings(str1, str2);

        // Performance analysis
        System.out.print("\nEnter number of iterations for performance test: ");
        int iterations = sc.nextInt();
        performanceTest(iterations);

        sc.close();
        System.out.println("\n=== ANALYSIS COMPLETE ===");
    }
}
