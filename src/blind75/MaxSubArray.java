package blind75;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(nums));
    }
    // brute force O(n^2) double nested loop.
    public static int maxSum(int[] nums) {

        int maxSum = nums[0];
        int currentSum = maxSum;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}
