package array;

public class FindMax {

    // Find Max j-i such that arr[j]> arr[i]
    public static void main(String[] args) {
        //O(n^2)
        int[] arr = {9, 2, 3, 4,5, 6, 7, 8 , 18, 0};

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[i] && max < j - i) {
                    max = j - i;
                }
            }
        }
        System.out.println(max);
    }
}
