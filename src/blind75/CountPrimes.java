package blind75;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(3));
    }
    public static int countPrimes(int n) {

        if ( n == 0 || n == 1) return 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i*i < n; i++) {
            for (int j = 2*i; j < n; j+=i) {
                primes[j] = false;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (primes[i]) count++;
        }

        return count;
    }
}
