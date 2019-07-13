// Вычисления с римскими числами

package calcpack;

import java.io.IOException;

public class Roman {

    public static String calc(String a, String operation, String b) throws IOException {

        int c = RomanToArabic.romanToArabic(a);
        int d = RomanToArabic.romanToArabic(b);
        int result = 0;

        switch (operation) {
            case "+":
                result = c + d;
                break;
            case "-":
                result = c - d;
                break;
            case "*":
                result = c * d;
                break;
            case "/":
                result = c / d;
                break;
            default:
                try {
                    throw new IOException();
                }
                catch(IOException exc) {
                    System.out.println("Неправильная арифметическая операция");
                    System.exit(0);
                }
        }

        return ArabicToRoman.arabicToRoman(result);

    }

}
