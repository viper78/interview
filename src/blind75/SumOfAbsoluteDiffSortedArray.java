package blind75;

import java.util.Arrays;

public class SumOfAbsoluteDiffSortedArray {

    // https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/

    /**
     * You are given an integer array nums sorted in non-decreasing order.
     *
     * Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.
     *
     * In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
     *
     *
     * @param nums
     * @return
     */
    public static void main(String[] args) {
        int[] nums = {1,4,6,8,10};
        Arrays.stream(getSumAbsoluteDifferences(nums)).forEach(System.out::println);
    }
    public static int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] result = new int[nums.length];

        int prefixSum = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            totalSum -= nums[i];
            int leftTotal = (nums[i] * i) - prefixSum;
            int rightTotal = totalSum - nums[i] * (n-1-i);
            result[i] = leftTotal + rightTotal;
            prefixSum += nums[i];
        }

        return result;
    }
}
