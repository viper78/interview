package array;

public class TwoAdjacentElementSum {

    public static void main( String[] args ) {

        int [] nums = {5, 6, 10, 100, 10, 5};

        int maxSum = findMaxAdjacentSum(nums);

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
}
