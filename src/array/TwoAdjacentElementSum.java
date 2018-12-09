package array;

public class TwoAdjacentElementSum {

    public static void main( String[] args ) {

        int [] nums = {10, 5, 6, 15};

//        int maxSum = findMaxAdjacentSum(nums);
        int maxSum = maxSum(nums);

        System.out.println(maxSum);
    }

    private static int findMaxAdjacentSum( int[] nums ) {

        int incl = nums[0];
        int excl = 0;

        for (int i = 1; i < nums.length; i++) {

            int temp = (incl > excl) ? incl : excl;

            incl = excl + nums[i];
            excl = temp;
        }

        return (incl > excl) ? incl :excl;
    }

    public static int maxSum(int arr[]) {
        int excl = 0;
        int incl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        return incl;
    }
}
