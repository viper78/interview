package sorting;


import java.util.Arrays;

public class QuickSorting {

    public static void main(String[] args) {

        int arr[] = {10, 30, 20, 5, 7, 9, 15};
        int[] sorted = quickSort(arr, 0, arr.length-1);
        Arrays.stream(sorted).forEach(System.out::println);
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right)/2];

        while(left <= right) {
            while(arr[left] < pivot) left++;

            while(arr[right] > pivot) right--;

            if (left <= right) {
                //swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return left;
    }
}
