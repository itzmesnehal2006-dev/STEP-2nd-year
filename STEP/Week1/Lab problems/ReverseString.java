public class ReverseString {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter a string: &quot;);
String input = sc.next();
String reversed = new StringBuilder(input).reverse().toString();
System.out.println(&quot;Reversed string: &quot; + reversed);
sc.close();
}
}