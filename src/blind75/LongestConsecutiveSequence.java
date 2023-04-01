package blind75;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    // nums = [100,4,200,1,3,2] -> 4
    // nums = [0,3,7,2,5,8,4,6,0,1] -> 9

    /**
     * https://leetcode.com/problems/longest-consecutive-sequence/
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     *
     * You must write an algorithm that runs in O(n) time.
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int current = 1;
            if (!set.contains(number - 1)) {
                while (set.contains(number + 1)) {
                    current += 1;
                    number += 1;
                }
            }
            max = Math.max(current, max);
        }

        return max;
    }
}
