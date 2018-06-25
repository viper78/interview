package array;

public class FindMedianSortedArray {

    public static void main(String[] args) {

        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        int size = 5;

        System.out.println(findMedian(arr1, arr2, 0, size-1, size));
    }

    private static int findMedian(int[] arr1, int[] arr2, int low, int high, int size) {

        if (high <= low) {
            return findMedian(arr2, arr1, 0, size - 1, size);
        }

        int mid = (low + high)/2;
        int median = arr1[mid];

        if (median <= arr2[size - (mid + 1)] && median <= arr2[size - mid]) {
            return median;
        }

        if (median >= arr2[size - (mid + 1)]) {
            return findMedian(arr1, arr2, 0, mid - 1, size);
        } else {
            return findMedian(arr1, arr2, mid + 1, size - 1, size);
        }

    }
}
