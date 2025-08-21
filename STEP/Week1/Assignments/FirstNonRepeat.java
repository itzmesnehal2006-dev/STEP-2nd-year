import java.util.Scanner;
public class FirstNonRepeat {
static char firstNonRepeating(String s) {
int[] freq = new int[256];
for (int i = 0; i &lt; s.length(); i++) {
freq[s.charAt(i)]++;
}
for (int i = 0; i &lt; s.length(); i++) {
if (freq[s.charAt(i)] == 1) return s.charAt(i);
}
return &#39;\0&#39;;

}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter a string: &quot;);
String s = sc.nextLine();
char ch = firstNonRepeating(s);
if (ch != &#39;\0&#39;)
System.out.println(&quot;First non-repeating character: &quot; + ch);
else
System.out.println(&quot;No unique character found.&quot;);
}
}