package array;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {

    void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
                continue;
            }
            nums[index] = - nums[index];
        }

        return result;
    }

    public static List<Integer> findDuplicates2(int[] arr) {
        // Use a set for results to avoid duplicates
        Set<Integer> resultSet = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            // Translate the value into an index (1 <= x <= len(arr))
            int index = Math.abs(arr[i]) - 1;

            // If the value at that index is negative, then we've already seen
            // that value so it's a duplicate. Otherwise, negate the value at
            // that index so we know we've seen it
            if (arr[index] < 0) {
                resultSet.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        // Return the array to it's original state
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return new ArrayList(resultSet);
    }

    // Driver program
    public static void main(String[] args)
    {
        FindDuplicates duplicate = new FindDuplicates();
//        int arr[] = {4,3,2,7,8,2,3,1};
        int arr[] = {10,2,5,10,9,1,1,4,3,7};
        int arr_size = arr.length;

//        duplicate.printRepeating(arr, arr_size);
        System.out.println(duplicate.findDuplicates(arr));
    }
}
