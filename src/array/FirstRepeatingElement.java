package array;

import java.util.HashSet;

public class FirstRepeatingElement {

    public static void main (String[] args) throws java.lang.Exception
    {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(printFirstRepeating(arr));

        int arr2[] = { 5, 3, 4, 3, 5, 6};
        System.out.println(printFirstNonRepeating(arr2));
    }

    private static int printFirstNonRepeating(int[] arr) {

        int min = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = arr.length - 1; i>=0; i-- ) {

            if (!set.contains(arr[i])) {
                min = i;
                set.add(arr[i]);
            }
        }

        return min;
    }

    private static int printFirstRepeating(int[] arr) {

        int min = -1;

        HashSet<Integer> set = new HashSet();

        for (int i = arr.length - 1; i >=0; i--) {

            if (set.contains(arr[i])) {
                min = i;
            } else {
                set.add(arr[i]);
            }
        }

        return min;
    }
}
