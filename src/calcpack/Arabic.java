// Вычисления с арабскими числами

package calcpack;

import java.io.IOException;

public class Arabic {

    public static int calc(int a,  String operation, int b) throws IOException {

        int result = 0;

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
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

        return result;

    }
}
