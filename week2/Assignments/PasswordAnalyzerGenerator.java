import java.util.*;

public class PasswordAnalyzerGenerator {

    // Method to analyze password using ASCII values
    public static int[] analyzePassword(String password) {
        int upper = 0, lower = 0, digit = 0, special = 0;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 65 && ascii <= 90) {
                upper++;
            } else if (ascii >= 97 && ascii <= 122) {
                lower++;
            } else if (ascii >= 48 && ascii <= 57) {
                digit++;
            } else if (ascii >= 33 && ascii <= 126) { // printable special chars
                special++;
            }
        }
        return new int[]{upper, lower, digit, special};
    }

    // Method to check common weak patterns
    public static boolean hasWeakPattern(String password) {
        String[] patterns = {"123", "abc", "qwerty", "password"};
        for (String p : patterns) {
            if (password.toLowerCase().contains(p)) {
                return true;
            }
        }
        return false;
    }

    // Method to calculate strength score
    public static int calculateScore(String password, int[] counts) {
        int score = 0;

        // Length points
        if (password.length() > 8) {
            score += (password.length() - 8) * 2;
        }

        // Variety bonus
        if (counts[0] > 0) score += 10; // uppercase
        if (counts[1] > 0) score += 10; // lowercase
        if (counts[2] > 0) score += 10; // digits
        if (counts[3] > 0) score += 10; // special chars

        // Deduct for weak patterns
        if (hasWeakPattern(password)) {
            score -= 10;
        }

        return score;
    }

    // Method to return strength level
    public static String getStrengthLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    // Method to generate strong password
    public static String generatePassword(int length) {
        if (length < 4) length = 8; // minimum safe length

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+<>?/{}[]|";

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        // Ensure one from each category
        sb.append(upper.charAt(rand.nextInt(upper.length())));
        sb.append(lower.charAt(rand.nextInt(lower.length())));
        sb.append(digits.charAt(rand.nextInt(digits.length())));
        sb.append(special.charAt(rand.nextInt(special.length())));

        // Fill remaining with mixed chars
        String all = upper + lower + digits + special;
        for (int i = 4; i < length; i++) {
            sb.append(all.charAt(rand.nextInt(all.length())));
        }

        // Shuffle characters for randomness
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            chars.add(sb.charAt(i));
        }
        Collections.shuffle(chars);

        StringBuilder shuffled = new StringBuilder();
        for (char c : chars) {
            shuffled.append(c);
        }

        return shuffled.toString();
    }

    // Display results in tabular format
    public static void displayResults(String[] passwords) {
        System.out.printf("%-15s %-8s %-8s %-10s %-8s %-12s %-6s %-10s%n",
                "Password", "Length", "Upper", "Lower", "Digits", "SpecialChars", "Score", "Strength");
        System.out.println("-------------------------------------------------------------------------------------");

        for (String pwd : passwords) {
            int[] counts = analyzePassword(pwd);
            int score = calculateScore(pwd, counts);
            String strength = getStrengthLevel(score);

            System.out.printf("%-15s %-8d %-8d %-10d %-8d %-12d %-6d %-10s%n",
                    pwd, pwd.length(), counts[0], counts[1], counts[2], counts[3], score, strength);
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input multiple passwords
        System.out.println("Enter number of passwords to analyze: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] passwords = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter password " + (i + 1) + ": ");
            passwords[i] = sc.nextLine();
        }

        // Display analysis
        displayResults(passwords);

        // Generate strong password
        System.out.println("\nEnter desired length for new strong password: ");
        int len = sc.nextInt();
        String strongPwd = generatePassword(len);
        System.out.println("Generated Strong Password: " + strongPwd);

        sc.close();
    }
}
