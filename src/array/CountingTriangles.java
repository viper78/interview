package array;

import java.util.Arrays;

public class CountingTriangles {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2};
        System.out.println(findNumberOfTriangles(nums));
    }
    static int findNumberOfTriangles(int arr[]) {
        int n = arr.length;
        // Sort the array elements in non-decreasing order
        Arrays.sort(arr);

        // Initialize count of triangles
        int count = 0;

        for (int i = 0; i < n-2; ++i) {
            for (int j = i+1; j < n - 1; ++j) {
                int k = j + 1;
                /* Find the rightmost element which is smaller
                   than the sum of two fixed elements
                   The important thing to note here is, we use
                   the previous value of k. If value of arr[i] +
                   arr[j-1] was greater than arr[k], then arr[i] +
                   arr[j] must be greater than k, because the
                   array is sorted. */
                while (k < n && arr[i] + arr[j] > arr[k]) {
                    k++;
                }
               /* Total number of possible triangles that can be
                  formed with the two fixed elements is k - j - 1.
                  The two fixed elements are arr[i] and arr[j].  All
                  elements between arr[j+1] to arr[k-1] can form a
                  triangle with arr[i] and arr[j]. One is subtracted
                  from k because k is incremented one extra in above
                  while loop. k will always be greater than j. If j
                  becomes equal to k, then above loop will increment
                  k, because arr[k] + arr[i] is always/ greater than
                  arr[k] */
                count += k - j - 1;
            }
        }
        return count;
    }
}
