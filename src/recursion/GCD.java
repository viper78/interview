package recursion;

public class GCD {

    // Euclidean Algorithm

    public static void main(String[] args) {
        System.out.println(gcdIterative(2, 6));

        System.out.println(gcdRecursive(2, 6));
    }

    private static int gcdRecursive(int num1, int num2) {

        if (num2 == 0) return num1;

        return gcdRecursive(num2, num1 % num2);
    }

    private static int gcdIterative(int num1, int num2) {

        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
    }
}
