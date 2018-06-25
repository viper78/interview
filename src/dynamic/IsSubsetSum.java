package dynamic;

import java.util.Arrays;

public class IsSubsetSum {

    public static void main(String[] args) {

        int[] nums = {2,4,5,3};
        int target = 9;

        boolean[][] cache = new boolean[nums.length + 1][target + 1];

        System.out.println(subsetSum(nums, target, cache));
    }

    // O(input size * total)
    private static boolean subsetSum(int[] nums, int target, boolean[][] cache) {

        for (int i = 0; i <= nums.length; i++) {
            cache[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (j - nums[i-1] >= 0) {
                    //"including the last element"
                    cache[i][j] = cache[i-1][j] || cache[i-1][j - nums[i-1]];
                } else {
                    //"excluding the last element"
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[nums.length][target];
    }
}
