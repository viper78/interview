package binarysearch;

public class PowerFunction {

    /**
     * Implement pow(x, n) % d.

     * In other words, given x, n and d,

     * find (xn % d)
     */
    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        int d = 5;

        int ans = pow(x, n, d);

        System.out.println(ans);
    }

    private static int pow(int x, int n, int d) {

        return pow(x, n) % d;
    }

    private static int pow(int x, int n) {
        if (n == 0) return 1;
        x = Math.abs(x);

        if (n % 2 == 0) {
            return pow(x, n/2) * pow(x, n/2);
        } else {
            return x * pow(x, n/2) * pow(x, n/2);
        }
    }

}
