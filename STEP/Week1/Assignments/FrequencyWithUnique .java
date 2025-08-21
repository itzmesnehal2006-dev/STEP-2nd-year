import java.util.Scanner;
public class FrequencyWithUnique {
static char[] uniqueCharacters(String s) {
char[] unique = new char[s.length()];
int index = 0;
for (int i = 0; i &lt; s.length(); i++) {
char c = s.charAt(i);
boolean isUnique = true;
for (int j = 0; j &lt; i; j++) {
if (s.charAt(j) == c) {
isUnique = false;
break;
}
}
if (isUnique) unique[index++] = c;
}
char[] result = new char[index];
System.arraycopy(unique, 0, result, 0, index);
return result;
}
static String[][] frequency(String s) {
char[] unique = uniqueCharacters(s);
int[] freq = new int[256];
for (int i = 0; i &lt; s.length(); i++) {
freq[s.charAt(i)]++;
}
String[][] result = new String[unique.length][2];
for (int i = 0; i &lt; unique.length; i++) {
result[i][0] = String.valueOf(unique[i]);
result[i][1] = String.valueOf(freq[unique[i]]);
}
return result;
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter a string: &quot;);
String s = sc.nextLine();
String[][] freq = frequency(s);
for (String[] row : freq) {
System.out.println(row[0] + &quot; : &quot; + row[1]);
}
}
}