package array;

import java.util.Arrays;

public class CommonElementsInArray {

    public static void main(String[] args) {

        int arr1[] = {1,3,4,6,7,9};
        int arr2[] = {1,2,4,5,9,10};

//        int arr[] = naiveSolution(arr1, arr2);
//        Arrays.stream(arr).filter(value -> value != 0).forEach(System.out::print);
        commonElements(arr1, arr2, arr1.length, arr2.length);

    }

    private static int[] naiveSolution(int[] arr1, int[] arr2) {
        int arr_len = Math.min(arr1.length, arr2.length);
        int arr[] = new int[arr_len];
        int pos = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {

                if (arr1[i] == arr2[j]) {
                    arr[pos] = arr1[i];
                    pos++;
                    break;
                }
            }
        }

        return arr;
    }

    private static void commonElements(int[] arr1, int[] arr2, int m, int n) {

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
    }
}
