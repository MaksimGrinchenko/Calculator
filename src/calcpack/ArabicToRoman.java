// Перевод арабских чисел в римские

package calcpack;

public class ArabicToRoman {

    public static String arabicToRoman(int n) {

        String[] romanNumerals = {"M", "D", "C", "L", "X", "V", "I"};
        int[] romanNumeralNums = {1000 ,500, 100, 50, 10, 5, 1};
        String finalRomanNum = "";

        for (int i = 0; i < romanNumeralNums.length; i++) {
            int currentNum = n / romanNumeralNums[i];
            if (currentNum == 0) {
                continue;
            }

            for (int j = 0; j < currentNum; j++) {
                finalRomanNum += romanNumerals[i];
            }

            n = n % romanNumeralNums[i];

        }

        return finalRomanNum;

    }

}


