package array;

public class Find3Numbers {

    public static void main (String[] args) {
        int arr[] = {12, 11, 10, 5, 6, 2, 30};
        find3Numbers(arr);
    }

    private static void find3Numbers(int[] arr) {

        int n = arr.length;

        int min = 0;
        int max = n - 1;

        int[] small = new int[n];
        small[0] = -1;

        for (int i = 1; i < n; i++) {

            if (arr[i] <= arr[min]) {
                min = i;
                small[i] = -1;
            } else {
                small[i] = min;
            }
        }

        int[] big = new int[n];
        big[n-1] = -1;

        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] >= arr[max]) {
                max = i;
                big[i] = -1;
            } else {
                big[i] = max;
            }
        }


        for (int i = 0; i < n; i++) {

            if (small[i] != -1 && big[i] != -1) {
                System.out.println(arr[small[i]] + " " + arr[i] + " " + arr[big[i]]);
            }
        }
    }
}
