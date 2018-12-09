package math;

import java.util.Arrays;
import java.util.List;

public class ReArrangeArray {

    public static void main(String[] args) {
        int[] nums= {3, 0, 1, 2};
        rearrange(nums, 4);
        Arrays.stream(nums).forEach(s-> System.out.print(s + " "));
    }

    // The function to rearrange an array in-place so that arr[i]
    // becomes arr[arr[i]].
    public static void rearrange(int arr[], int n) {
        // First step: Increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++)
            arr[i] += (arr[arr[i]] % n) * n;

        Arrays.stream(arr).forEach(System.out::println);

        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }
}
