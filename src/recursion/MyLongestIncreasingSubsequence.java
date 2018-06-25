package recursion;

import java.util.Arrays;

public class MyLongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
        int[] arr1 = {3, 4, -1, 0, 6, 2, 3};
//        int[] arr1 = {2, 5, 1, 8, 3};
        int[] cache = new int[arr.length];
        Arrays.fill(cache, 1);
        int[] actualSolution = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            actualSolution[i] = i;
        }

        int max = Integer.MIN_VALUE;
//
        int m1 = iterative(arr, cache, actualSolution);
        System.out.println("Iterative:"+m1);
    }

    private static int iterative(int[] arr, int[] cache, int[] actualSolution) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (cache[j] + 1 > cache[i]) {
                        cache[i] = cache[j] + 1;
                        actualSolution[i] = j;
                    }
                }
            }
        }

        Arrays.stream(actualSolution).forEach(System.out::print);
        System.out.println();

        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] > max) {
                max = cache[i];
                maxIndex = i;
            }
        }

        System.out.println("max Index:"+ maxIndex);
        while (max > 0) {
            System.out.print(arr[maxIndex] + " ");
            maxIndex = actualSolution[maxIndex];
            max--;
        }

        return Arrays.stream(cache).max().getAsInt();
    }



}
