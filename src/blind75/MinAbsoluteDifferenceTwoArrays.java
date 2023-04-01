package blind75;

import java.util.TreeSet;

public class MinAbsoluteDifferenceTwoArrays {

    // https://leetcode.com/problems/minimum-absolute-sum-difference/description/

    /**
     * You are given two positive integer arrays nums1 and nums2, both of length n.
     *
     * The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
     *
     * You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.
     *
     * Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.
     *
     * |x| is defined as:
     *
     * x if x >= 0, or
     * -x if x < 0.
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1,7,5};
        int[] nums2 = {2,3,5};

        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int maxDecrease = 0;
        int len = nums1.length;
        long sum = 0;
        int mod = (int)Math.pow(10,9) + 7;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums1)
            treeSet.add(num);
        for (int i = 0; i < len; i++) {
            sum = sum + Math.abs(nums1[i] - nums2[i]);
            if (nums1[i] != nums2[i]) {
                // use binary search to find the replacement value to minimize the abs diff for current nums2[i]
                Integer ceil = treeSet.ceiling(nums2[i]);
                Integer floor = treeSet.floor(nums2[i]);
                int diff = Math.abs(nums1[i] - nums2[i]);
                int max = 0;
                if (ceil != null) {
                    int val1 = Math.abs(ceil - nums2[i]);
                    max = Math.max(max, diff - val1);
                }
                if (floor != null) {
                    int val2 = Math.abs(floor - nums2[i]);
                    max = Math.max(max, diff - val2);
                }
                //find the biggest delta across the entire array
                //the delta is diff = orginal diff - diff after replacement
                maxDecrease = Math.max(max, maxDecrease);
            }
        }
        return (int)((sum - maxDecrease) % mod);
    }
}
