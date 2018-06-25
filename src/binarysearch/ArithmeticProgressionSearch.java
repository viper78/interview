package binarysearch;

/**
 * Created by rajeshsubramanian on 3/12/18.
 */
public class ArithmeticProgressionSearch {

    public static void main( String[] args ) {
        int input[] = {1,7,10,13,16,19,22};
        System.out.println(missingNumber(input));
    }

    private static int missingNumber( int[] input ) {

        int low = 0;
        int high = input.length - 1;
        int mid = -1;
        int diff = (input[high] - input[low])/input.length;

        while ( low <= high ) {
//            mid = (high - low)/2;
            mid = low + (high - low)/2;
            if (input[mid] == input[0] + mid * diff) {
                low = mid + 1;
            } else if (input[mid] > input[0] + (mid *diff) && input[mid - 1] == input[0] + (mid-1)*diff) {
                return input[0] + mid * diff;
            } else {
                high = mid -1;
            }
        }

        return -1;
    }
}
