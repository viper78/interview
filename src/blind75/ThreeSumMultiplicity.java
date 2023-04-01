package blind75;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumMultiplicity {

    /**
     * https://leetcode.com/problems/3sum-with-multiplicity/description/
     *
     * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
     *
     * As the answer can be very large, return it modulo 109 + 7.
     *
     *
     * @param arr
     * @param target
     * @return
     */
    public int threeSumMulti(int[] arr, int target) {
        //O(N^2) complexity

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            count += map.getOrDefault(target - arr[i], 0);
            count %= 1000000007;
            for (int j = 0; j < i; j++) {
                map.put(arr[i] + arr[j], map.getOrDefault(arr[i] + arr[j], 0)+1);
            }
        }

        return count;
    }
}
