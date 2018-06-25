package array;

import java.util.Arrays;

public class MergeArrays {

    public static void main(String[] args) {

        int arr1[] = {1, 3, 5, 0, 0, 0};
        int arr2[] = {2, 4, 6};

        Arrays.stream(merge(arr1, arr2)).forEach(System.out::print);
    }

    private static int[] merge(int[] arr1, int[] arr2) {

        int l1 = arr1.length - 1;
        int l2 = arr2.length -1;

        while (l1 >= 0 && l2 >= 0) {
            if (arr1[l1] < arr2[l2]) {
                arr1[l1] = arr2[l2];
            }
            l1--;
            l2--;
        }

        return arr1;
    }
}
