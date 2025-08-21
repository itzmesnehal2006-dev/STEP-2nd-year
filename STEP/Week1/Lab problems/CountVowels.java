import java.util.Scanner;
public class CountVowels {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter a string: &quot;);
String input = sc.next().toLowerCase();
int count = 0;
for (int i = 0; i &lt; input.length(); i++) {
char ch = input.charAt(i);
if (ch == &#39;a&#39; || ch == &#39;e&#39; || ch == &#39;i&#39; || ch == &#39;o&#39; || ch == &#39;u&#39;)
count++;
}
System.out.println(&quot;Number of vowels: &quot; + count);
sc.close();
}
}