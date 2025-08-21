public class StringPerformanceComparison {
    public static void main(String[] args) {
        int iterations = 100_000; // number of concatenations
        long startTime, endTime;

        System.out.println("=== PERFORMANCE COMPARISON ===");

        // Test 1: String concatenation
        startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a"; // creates new object every time
        }
        endTime = System.nanoTime();
        System.out.println("String Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Test 2: StringBuilder concatenation
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Test 3: StringBuffer concatenation
        startTime = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append("a");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime
