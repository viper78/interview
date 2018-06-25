package array;

import java.util.Arrays;

public class RotateSingleArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int k = 2;

        rotateArray(arr, k);

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void rotateArray(int[] arr, int k) {

        int mid = arr.length - k;

        int left = 0;
        int right = mid - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        left = mid;
        right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        left = 0;
        right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }


}
