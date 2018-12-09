package array;

public class SmallestPositiveMissingNumber {

    public static void main (String[] args) {
        int arr[] = {0, 10, 4, -10, -20, 1};
        int arr_size = arr.length;
        int missing = findMissing(arr);
        System.out.println("The smallest positive missing number is "+
                missing);
    }

    private static int findMissing(int[] arr) {

        int size = arr.length;

        int low = 0;
        int index = 0;

        while (index < size) {
            if (arr[index] <= 0) {
                swap(arr, low, index);
                low++;
            }
            index++;
        }

        int[] arr2 = new int[size-low];

        int j = 0;
        for (int i = low; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }

        size = arr2.length;

        for (int i = 0; i < size; i++) {

            if (Math.abs(arr2[i]) - 1 < size && arr2[Math.abs(arr2[i]) - 1] > 0) {
                arr2[Math.abs(arr2[i]) - 1] = - arr2[Math.abs(arr2[i]) - 1];
            }
        }

        for (int i = 0; i < size; i++) {
            if (arr2[i] > 0) {
                return i+1;
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
