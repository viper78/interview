package blind75;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraySumToK {

    /**
     * https://leetcode.com/problems/subarray-sum-equals-k/
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     *
     * @param args
     */
    public static void main(String[] args) {

    }
    static int solve(int[] nums, int k) {
        int result = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        //map.put(0,1);

        for (int n: nums) {
            sum += n;
            if (sum == k) {
                result++;
            }
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return result;
    }
}
