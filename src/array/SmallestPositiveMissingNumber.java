package array;

public class SmallestPositiveMissingNumber {

    public static void main (String[] args) {
        int arr[] = {0, 2, 1, -10, -20, 10};
        int arr_size = arr.length;
        int missing = findMissing(arr, arr_size);
        System.out.println("The smallest positive missing number is "+
                missing);
    }

    static int findMissing(int arr[], int size) {
        // First separate positive and
        // negative numbers


        int low = 0;
        int index = 0;

        while (index < size) {
            if (arr[index] <= 0) {
                swap(arr, low, index);
                low++;
            }
            index++;
        }

//        int shift = segregate (arr, size);

        int arr2[] = new int[size-low];
        int j=0;
        for(int i = low; i < size;i++)
        {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* Find the smallest positive missing
       number in an array that contains
       all positive integers */
    static int findMissingPositive(int arr[], int size) {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for(i = 0; i < size; i++)
        {

            if( Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }

        // Return the first index value at which
        // is positive
        for(i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1;  // 1 is added becuase indexes
        // start from 0

        return size+1;
    }

    /* Find the smallest positive missing
       number in an array that contains
       both positive and negative integers */

    // main function

}
