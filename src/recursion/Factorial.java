package recursion;

public class Factorial {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(naiveSolution(n));

        System.out.println(factorial(1, 5));
    }

    private static int naiveSolution(int n) {

        if (n == 1) return 1;
        return n * naiveSolution(n-1);
    }

    private static int factorial(int result, int n) {

        if (n == 1) return result;

        return factorial(result * n, n-1);
    }
}
