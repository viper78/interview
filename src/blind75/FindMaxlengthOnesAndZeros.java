package blind75;

import java.util.HashMap;
import java.util.Map;

public class FindMaxlengthOnesAndZeros {

    // Find max length of continuous array with Same number of Ones and Zeros
    //https://leetcode.com/problems/contiguous-array/solutions/
    public static void main(String[] args) {
//        int[] nums = {1,1,0,0,1,0,1,1};
        int[] nums = {0,1,0,0};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {

        int longest = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (map.containsKey(count)) {
                longest = Math.max(longest, i - map.get(count) );
            } else {
                map.put(count, i);
            }
        }
        return longest;
    }
}
