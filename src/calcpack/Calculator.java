/* Консольное приложение “Калькулятор”.
   Приложение должно читать из консоли введенные пользователем
   арифметические операции и выводить в консоль результат их выполнения. */

package calcpack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] primer = reader.readLine().split(" ");

        String a = primer[0];
        String operation = primer [1];
        String b = primer[2];

        Pattern pat = Pattern.compile("[0-9]");
        Matcher mat1 = pat.matcher(a);
        Matcher mat2 = pat.matcher(b);

        Pattern pat1 = Pattern.compile("[a-zA-Z]");
        Matcher mat3 = pat1.matcher(a);
        Matcher mat4 = pat1.matcher(b);

        Pattern pat2 = Pattern.compile("[0-9]+\\.[0-9]+");
        Matcher mat5 = pat2.matcher(a);
        Matcher mat6 = pat2.matcher(b);

        boolean ismfound1 = mat1.find();
        boolean ismfound2 = mat2.find();
        boolean ismfound3 = mat3.find();
        boolean ismfound4 = mat4.find();
        boolean ismfound5 = mat5.find();
        boolean ismfound6 = mat6.find();

        if(ismfound1 && ismfound2) {

            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);

            if (((c < -32768 || c > 32767) || (d < -32768 || d > 32767)) ||
                ((c < -32768 || c > 32767) && (d < -32768 || d > 32767))) {
                try {
                    throw new IOException();
                } catch (IOException exc) {
                    System.out.println("Ввели неподходящие числа");
                }
            }

            else
                System.out.println(Arabic.calc(c, operation, d));
        }

        if(ismfound3 && ismfound4) {
            int c = RomanToArabic.romanToArabic(a);
            int d = RomanToArabic.romanToArabic(b);

            if(((c < 0 || c > 32767) || (d < 0 || d > 32767)) ||
               ((c < 0 || c > 32767) && (d < 0 || d > 32767))) {
                try {
                    throw new IOException();
                }
                catch (IOException exc) {
                    System.out.println("Ввели неподходящие числа");
                }
            }

            else
                System.out.println(Roman.calc(a, operation, b));

        }

        if((ismfound1 && ismfound4) || (ismfound3 && ismfound2)) {
            try {
                throw new IOException();
            }
            catch (IOException exc) {
                System.out.println("Одновременно ввели арабские и римские цифры");
            }
        }

        if((ismfound5 && ismfound2) || (ismfound1 && ismfound6) || (ismfound5 && ismfound6)) {
            try {
                throw new IOException();
            }
            catch (IOException exc) {
                System.out.println("Ввели нецелое число");
            }
        }

    }
}
