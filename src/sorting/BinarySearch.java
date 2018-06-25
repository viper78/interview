package sorting;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearchRecursive(arr, 10));
    }

    private static int binarySearchRecursive(int[] arr, int num) {

        return binarySearch(arr, num, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int num, int start, int end) {

        if (start > end) return -1;

        int mid = (start + end) /2;

        if (num == arr[mid]) {
            return mid;
        } else if (num < arr[mid]) {
            return binarySearch(arr, num, start, mid -1);
        } else {
            return binarySearch(arr, num, mid + 1, end);
        }

    }
}
