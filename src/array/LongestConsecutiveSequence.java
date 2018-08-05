package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 1,3,2,2, 4};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int max = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int end = num;
                while (set.contains(end)) {
                    end++;
                }
                max = Math.max(max, end - num);
            }
        }

        return max;
    }
}
