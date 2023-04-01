package blind75;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySumMultipleOfK {

    // https://leetcode.com/problems/continuous-subarray-sum/

    /**
     * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
     *
     * A good subarray is a subarray where:
     *
     * its length is at least two, and
     * the sum of the elements of the subarray is a multiple of k.
     * @param
     * @param
     * @return
     */

    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 11, 9};
        int k = 7;
        System.out.println(checkSubarraySum(nums, k));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        // Map of remainder and index
        Map<Integer, Integer> map = new HashMap<>();

        if (k==0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i-1] == 0) {
                    return true;
                }
            }
        }
        map.put(0, -1);
        // Use prefix sum for contiguous elements.
        // (sum2 - sum1) % k = 0; sum2 % k = sum1 % k
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum % k)) {
                if (i - map.get(prefixSum%k) > 1) {
                    return true;
                }
            }
            map.putIfAbsent(prefixSum % k, i);
        }

        return false;
    }
}
