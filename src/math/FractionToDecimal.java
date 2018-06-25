package math;

public class FractionToDecimal {

    public static void main(String[] args) {

        int num = 3;
        int den = 3;

        System.out.println(convertDecimal(num, den));
    }

    private static String convertDecimal(int num, int den) {

        String out = "";

        int quotient = num/den;
        int remainder = num%den;
        out += quotient;
        out += ".";
        if (remainder == 0) {
            out += remainder;
            return out;
        }

        while (remainder != 0) {
            remainder = (remainder%den) * 10;
            out += remainder/den;
        }

        return out;
    }
}
