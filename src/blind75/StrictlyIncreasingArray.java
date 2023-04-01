package blind75;

public class StrictlyIncreasingArray {

    public static void main(String[] args) {
        int[] nums = {1,3,900,10};
        // {13, 31, 30}
        // {31, 13, 40}
        System.out.println(compute(nums));


    }

    static boolean compute(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (count > 1) {
                return false;
            }
            if (nums[i] >= nums[i+1]) {
              //  int temp = swapToSmallest(nums[i]);

                count++;
            }
        }
        return true;
    }


}
