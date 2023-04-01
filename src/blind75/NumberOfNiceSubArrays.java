package blind75;

import java.util.HashMap;

public class NumberOfNiceSubArrays {

    // https://leetcode.com/problems/count-number-of-nice-subarrays/

    /**
     * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k
     * odd numbers on it.
     *
     * Return the number of nice sub-arrays.
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = {2,2,2,1,2,2,1,2,2,2,1};
        System.out.println(numberOfSubarrays(nums, 2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {


        int[] numbers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                numbers[i] = 0;
            } else {
                numbers[i] = 1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap();
       // map.put(0, 1);
        int sum = 0;
        int result = 0;

        // prefix sum used for contiguous sub array
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (sum == k) {
                result++;
            }

            if (map.containsKey(sum - k)) {
                result += map.get(sum -k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
