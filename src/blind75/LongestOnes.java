package blind75;

import java.util.Arrays;

public class LongestOnes {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int[] nums = {0,0,0,0};
        int k = 0;

        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int right = 0;

        for (right = 0; right < nums.length; right++) {
            int curr = nums[right];
            if (curr == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }
        return right-left;
    }
}
