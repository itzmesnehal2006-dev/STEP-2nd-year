import java.util.Scanner;
public class StringCaseConversion {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter a string: &quot;);
String input = sc.next();
System.out.println(&quot;Uppercase: &quot; + input.toUpperCase());
System.out.println(&quot;Lowercase: &quot; + input.toLowerCase());
sc.close();
}
}