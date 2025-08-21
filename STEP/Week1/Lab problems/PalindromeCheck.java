import java.util.Scanner;
public class PalindromeCheck {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter a string: &quot;);
String input = sc.next();
String reversed = new StringBuilder(input).reverse().toString();
if (input.equals(reversed))
System.out.println(&quot;Palindrome&quot;);
else
System.out.println(&quot;Not Palindrome&quot;);

sc.close();
}
}