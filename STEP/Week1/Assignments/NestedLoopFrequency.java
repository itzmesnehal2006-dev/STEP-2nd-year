import java.util.Scanner;
public class NestedLoopFrequency {
static String[] frequency(String s) {
char[] chars = s.toCharArray();
int[] freq = new int[chars.length];
for (int i = 0; i &lt; chars.length; i++) {

if (chars[i] == &#39;0&#39;) continue;
freq[i] = 1;
for (int j = i+1; j &lt; chars.length; j++) {
if (chars[i] == chars[j]) {
freq[i]++;
chars[j] = &#39;0&#39;;
}
}
}
String[] result = new String[chars.length];
int index = 0;
for (int i = 0; i &lt; chars.length; i++) {
if (chars[i] != &#39;0&#39;) {
result[index++] = chars[i] + &quot; : &quot; + freq[i];
}
}
String[] finalResult = new String[index];
System.arraycopy(result, 0, finalResult, 0, index);
return finalResult;
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter a string: &quot;);
String s = sc.nextLine();
String[] freq = frequency(s);
for (String row : freq) System.out.println(row);
}
}