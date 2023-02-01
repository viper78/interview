package blind75;

public class findBestSubArray {

    /*
    * Given an integer array nums and an integer k,
    * find the sum of the subarray with the largest sum whose length is k.
     */
    public static void main(String[] args) {
        int[] nums = {3, -1, 4, 12, -8, 5, 6};
        int k = 4;

        int current = 0;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            current += nums[i];
        }
        ans = current;
        for (int i = k; i < nums.length; i++) {
            current = current - nums[i-k] + nums[k];
            ans = Math.max(ans, current);
        }
        System.out.println(ans);

    }
}
