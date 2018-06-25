package array;

public class SecondLargest {

    public static void main(String[] args) {

        int arr[] = {12, 35, 1, 10, 34, 1};
        // O(n)
        System.out.println(secondLargest(arr));
    }

    private static int secondLargest(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int secondmax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondmax && arr[i] < max) {
                secondmax = arr[i];
            }
        }

        return secondmax;
    }
}
