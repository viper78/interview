package math;

import java.util.ArrayList;
import java.util.List;

public class PrimeSum {

    public static void main(String[] args) {

        System.out.println(primesum(12));
    }

    public static List<Integer> primesum(int A) {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 2; i < A; i++) {
            if (isPrime(i) && isPrime(A - i)) {
                arr.add(i);
                arr.add(A - i);
                return arr;
            }
        }
        return arr;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
