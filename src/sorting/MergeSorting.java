package sorting;

import java.util.Arrays;

public class MergeSorting {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 9, 13, 7, 20, 15, 44,32, 70, 12, 2, 100, 80, 70, 23, 55,66};
        int[] helper = new int[arr.length];

        int[] mergedArr = mergeSort(arr, helper, 0, arr.length - 1);

        Arrays.stream(mergedArr).forEach(System.out::println);
    }

    private static int[] mergeSort(int[] arr, int[] helper, int start, int end) {

        if (start < end) {
            int mid = (start + end)/2;
            mergeSort(arr, helper, start, mid);
            mergeSort(arr, helper, mid + 1, end);
            return merge(arr, helper, start, mid, end);
        }
        return null;
    }

    private static int[] merge(int[] arr, int[] helper, int start, int mid, int end) {

        for (int i = 0; i < arr.length; i ++) {
            helper[i] = arr[i];
        }

        int left = start;
        int right = mid + 1;
        int current = start;

        while(left <= mid && right <= end) {
            if (helper[left] < helper[right]) {
                arr[current] = helper[left];
                left++;
            } else {
                arr[current] = helper[right];
                right++;
            }
            current++;
        }

        int remaining = mid - left;
        for (int i = 0; i <=remaining; i++) {
            arr[current + i] = helper[left+i];
        }

        return arr;
    }
}
