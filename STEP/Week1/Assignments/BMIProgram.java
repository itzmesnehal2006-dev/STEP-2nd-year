import java.util.Scanner;
public class BMIProgram {
// Method to calculate BMI and status
static String[][] calculateBMI(double[][] hw) {
String[][] result = new String[hw.length][4];
for (int i = 0; i &lt; hw.length; i++) {
double heightMeters = hw[i][1] / 100.0;
double bmi = hw[i][0] / (heightMeters * heightMeters);
String status;
if (bmi &lt; 18.5) status = &quot;Underweight&quot;;
else if (bmi &lt; 25) status = &quot;Normal&quot;;
else if (bmi &lt; 30) status = &quot;Overweight&quot;;
else status = &quot;Obese&quot;;
result[i][0] = String.format(&quot;%.2f&quot;, hw[i][0]);
result[i][1] = String.format(&quot;%.2f&quot;, hw[i][1]);
result[i][2] = String.format(&quot;%.2f&quot;, bmi);
result[i][3] = status;
}
return result;
}
// Method to display result
static void display(String[][] arr) {
System.out.printf(&quot;%-10s %-10s %-10s %-15s%n&quot;, &quot;Weight&quot;, &quot;Height&quot;, &quot;BMI&quot;, &quot;Status&quot;);
for (String[] row : arr) {
System.out.printf(&quot;%-10s %-10s %-10s %-15s%n&quot;, row[0], row[1], row[2], row[3]);
}
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
double[][] hw = new double[10][2];
for (int i = 0; i &lt; 10; i++) {
System.out.print(&quot;Enter weight (kg) for person &quot; + (i+1) + &quot;: &quot;);
hw[i][0] = sc.nextDouble();
System.out.print(&quot;Enter height (cm) for person &quot; + (i+1) + &quot;: &quot;);
hw[i][1] = sc.nextDouble();
}
String[][] result = calculateBMI(hw);
display(result);
}
}