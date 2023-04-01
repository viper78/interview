package blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class KDiffPairs {

    /**
     * https://leetcode.com/problems/k-diff-pairs-in-an-array/
     * Given an array of integers nums and an integer k, return the number of UNIQUE k-diff pairs in the array.
     *
     * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
     *
     * 0 <= i, j < nums.length
     * i != j
     * nums[i] - nums[j] == k
     * Notice that |val| denotes the absolute value of val.
     * @param args
     */
    public static void main(String[] args) {
            int[] nums = {3,1,4,1,5};
            int k = 2;
    }
    public int findPairs(int[] nums, int k) {

        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {

            if (k != 0) {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            } else {
                if (entry.getValue() >= 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
