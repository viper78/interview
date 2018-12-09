package math;

import sun.misc.FloatingDecimal;

public class StringToNumber {

    public static void main(String[] args) {

        String num1 = "-24E+2";

//        System.out.println(FloatingDecimal.parseDouble(num1));
        System.out.println(getNumber(num1));
    }

    private static double getNumber(String str) {

        boolean isNegative = false;
        boolean isDecSeen = false;
        boolean isExpSeen = false;
        int expSign = 1;
        int expValue = 1;

        // Trim
        str = str.trim();
        // Check -ve
        int i = 0;
        if (str.charAt(0) == '-') {
            isNegative = true;
            i = 1;
        }

        double total = 0;
        while (i < str.length()) {

            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                total *= 10;
                total += ch - '0';
            }
            else if (ch == '.') {
                if (isDecSeen) {
                    throw new NumberFormatException();
                }
                isDecSeen = true;
            } else if (ch == 'e' || ch == 'E') {
                if (isExpSeen) {
                    throw new NumberFormatException();
                }
                isExpSeen = true;

                char c1 = str.charAt(++i);
                if (c1 == '-') {
                    expSign = -1;
                }

                char c2 = str.charAt(++i);
                if (c2 >='0' && c2 <= '9') {
                    int j = 1;
                    int temp = 10;
                    while (j < c2 - '0') {
                        temp *= 10;
                        j++;
                    }
                    total *= temp;
                    if (isDecSeen) {
                        total /= 10;
                    }
                }
            }
            i++;
        }

        if (isNegative) {
            total = -total;
        }
        return total;
    }
}
