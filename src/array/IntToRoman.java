package array;

public class IntToRoman {

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        int num = 1945;
        int num1 = 2500;
        System.out.println(intToRoman(num));
        System.out.println(intToRoman(num1));
    }

    private static String intToRoman(int num) {

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < values.length;) {

            if (num >= values[i]) {
                num = num - values[i];
                buffer.append(romans[i]);
            }
            if (num < values[i]) {
                i++;
            }
        }

        return buffer.toString();
    }
}
