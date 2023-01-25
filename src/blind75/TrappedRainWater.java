package blind75;

import java.util.Arrays;

public class TrappedRainWater {

    public static void main(String[] args) {
        int arr[] = {3, 0, 0, 2, 0, 4};
        int n = 6;

        System.out.println(solve(arr, n));
    }

    public static int solve (int[] arr, int n) {

        int[] left = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        System.out.println("left:"+ Arrays.toString(left));

        int[] right = new int[n];

        right[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        System.out.println("right:"+ Arrays.toString(right));
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(left[i], right[i]) - arr[i];
        }

        return totalWater;
    }
}
