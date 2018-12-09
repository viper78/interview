package array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = {2,2,3,3,4,4,1, 4};
        System.out.println(singleNumber(nums));

    }

    private static int singleNumber (int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {

            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        for (int n : nums) {
            if (map.get(n) == 1) {
                return n;
            }
        }

        return -1;
    }
}
