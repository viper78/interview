package math;

public class IsPowerOfTwo {

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(32));
        System.out.println(isPowerOfTwo(21));
        System.out.println(isPowerOfTwo(19));
    }

    static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        while (n != 1)
        {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }
}
