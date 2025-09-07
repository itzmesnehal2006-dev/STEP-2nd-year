import java.util.*;

public class TextCalculator {

    // Validate expression
    public static boolean validateExpression(String expr) {
        int parenBalance = 0;
        char prev = ' ';

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // Valid characters: digits, operators, parentheses, space
            if (!Character.isDigit(c) && "+-*/() ".indexOf(c) == -1) {
                return false; // invalid char
            }

            // Check parentheses balance
            if (c == '(') parenBalance++;
            if (c == ')') parenBalance--;

            if (parenBalance < 0) return false;

            // Validate operator placement (no two consecutive operators)
            if ("+-*/".indexOf(c) != -1 && "+-*/".indexOf(prev) != -1) {
                return false;
            }

            if (c != ' ') prev = c;
        }

        return parenBalance == 0; // parentheses must balance
    }

    // Parse numbers and operators
    public static List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        int i = 0;

        while (i < expr.length()) {
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                int start = i;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    i++;
                }
                tokens.add(expr.substring(start, i)); // number
            } else if ("+-*/()".indexOf(c) != -1) {
                tokens.add(String.valueOf(c)); // operator or paren
                i++;
            } else {
                i++; // skip spaces
            }
        }
        return tokens;
    }

    // Evaluate simple expression (no parentheses) with steps
    public static int evaluateTokens(List<String> tokens, StringBuilder steps) {
        // Handle * and /
        for (int i = 0; i < tokens.size(); i++) {
            String t = tokens.get(i);
            if (t.equals("*") || t.equals("/")) {
                int a = Integer.parseInt(tokens.get(i - 1));
                int b = Integer.parseInt(tokens.get(i + 1));
                int res = t.equals("*") ? a * b : a / b;

                steps.append(a + " " + t + " " + b + " = " + res + "\n");

                tokens.set(i - 1, String.valueOf(res));
                tokens.remove(i); // operator
                tokens.remove(i); // right operand
                i--;
            }
        }

        // Handle + and -
        while (tokens.size() > 1) {
            int a = Integer.parseInt(tokens.get(0));
            String op = tokens.get(1);
            int b = Integer.parseInt(tokens.get(2));
            int res = 0;

            if (op.equals("+")) res = a + b;
            else res = a - b;

            steps.append(a + " " + op + " " + b + " = " + res + "\n");

            tokens.set(0, String.valueOf(res));
            tokens.remove(1);
            tokens.remove(1);
        }

        return Integer.parseInt(tokens.get(0));
    }

    // Evaluate with parentheses
    public static int evaluateExpression(String expr, StringBuilder steps) {
        // Resolve parentheses first
        while (expr.contains("(")) {
            int open = expr.lastIndexOf("(");
            int close = expr.indexOf(")", open);

            String inside = expr.substring(open + 1, close);
            List<String> tokens = tokenize(inside);
            int result = evaluateTokens(new ArrayList<>(tokens), steps);

            expr = expr.substring(0, open) + result + expr.substring(close + 1);
        }

        // Evaluate final flat expression
        List<String> tokens = tokenize(expr);
        return evaluateTokens(new ArrayList<>(tokens), steps);
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a mathematical expression: ");
        String expr = sc.nextLine();

        // Step 1: Validation
        if (!validateExpression(expr)) {
            System.out.println("Invalid expression!");
            return;
        }

        // Step 2: Evaluation with steps
        StringBuilder steps = new StringBuilder();
        int result = evaluateExpression(expr, steps);

        // Step 3: Display steps
        System.out.println("\n=== CALCULATION STEPS ===");
        System.out.println(steps.toString());

        System.out.println("Final Result: " + result);

        sc.close();
    }
}
