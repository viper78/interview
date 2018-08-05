package math;

public class AddTwoNumbers {

    public static void main(String[] args) {

        try {
//            int r1 = add(Integer.MAX_VALUE, 5);
//
//            int r2 = add(Integer.MAX_VALUE - 5, 4);
//
//            int r3 = add(Integer.MIN_VALUE, -5);

            System.out.println(getSum(1, 3));

            System.out.println(getSubtract(3, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int add(Integer n1, Integer n2) throws Exception{

        int result = -1;
        if (n1 > 0 && n2 > 0) {
            if (Integer.MAX_VALUE - n1 < n2 || Integer.MAX_VALUE - n2 < n1) {
                System.out.println("Invalid");
                return result;
            } else {
                result = n1 + n2;
                System.out.println(result);
            }
        } else if (n1 < 0 && n2 < 0) {
            if (Integer.MIN_VALUE - n1 > n2 || Integer.MIN_VALUE - n2 > n1) {
                System.out.println("Invalid");
            } else {
                result = n1 + n2;
                System.out.println(result);
            }
        } else {
            result = n1 + n2;
            System.out.println(result);
        }

        return result;
    }

    public static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    // Iterative
    public static int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }
}
