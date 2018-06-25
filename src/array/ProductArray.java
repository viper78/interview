package array;

import java.util.Arrays;

public class ProductArray {

    // O(n)
    public static void main(String[] args) {
        int[] arr = {10,3,5,6,2};

        int[] result = solve(arr);

        Arrays.stream(result).forEach(s -> System.out.print(s + " "));
    }

    private static int[] solve(int[] arr) {

        int[] l = new int[arr.length];
        int[] r = new int[arr.length];
        int[] result = new int[arr.length];

        l[0] = 1;
        r[arr.length - 1] = 1;

        for (int i = 1; i < arr.length; i++) {
            l[i] = arr[i - 1] * l[i-1];
        }

        for (int j = arr.length - 2; j >= 0; j--) {
            r[j] = arr[j + 1] * r[j + 1];
        }

        for (int k = 0; k < arr.length; k++) {
            result[k] = l[k] * r[k];
        }


        return result;
    }
}
