package array;

import java.util.Arrays;

public class RotateSingleArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int k = 2;

        rotate(arr, k);

        Arrays.stream(arr).forEach(s -> System.out.print(s +" "));
    }

    public static void rotate(int[] arr, int k) {
        if (arr == null || arr.length==0 || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }

        if(k > arr.length){
            k = k %arr.length;
        }

        //length of first part
        // Rotate right
        int a = arr.length - k;
        // Rotate left
//        int a = k;

        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);

    }

    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
