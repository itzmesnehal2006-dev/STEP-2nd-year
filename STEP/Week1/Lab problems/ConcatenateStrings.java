import java.util.Scanner;
public class ConcatenateStrings {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter first string: &quot;);
String str1 = sc.next();
System.out.print(&quot;Enter second string: &quot;);
String str2 = sc.next();
String result = str1 + str2;
System.out.println(&quot;Concatenated string: &quot; + result);
sc.close();
}
}