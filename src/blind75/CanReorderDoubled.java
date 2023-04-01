package blind75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CanReorderDoubled {
    // https://leetcode.com/problems/array-of-doubled-pairs/

    /**
     * Given an integer array of even length arr, return true if it is possible to
     * reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for
     * every 0 <= i < len(arr) / 2, or false otherwise.
     * @param args
     */
    public static void main(String[] args) {

//        int[] arr = {1, 2, 4, 16, 8, 4};
        int[] arr = {4,-2,2,-4};
        System.out.println(canReorderDoubled(arr));
    }

        public static boolean canReorderDoubled(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int num: arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            Integer[] sorted = new Integer[arr.length];
            for (int i = 0; i < arr.length; i++) {
                sorted[i] = arr[i];
            }
            Arrays.sort(sorted, Comparator.comparingInt(Math::abs));

            for (int num: sorted) {

                int count = map.get(num);
                if (count == 0) continue;
                if (map.getOrDefault(2 * num, 0) <= 0) {
                    return false;
                }
                map.put(2*num, map.get(2*num) - 1);
                map.put(num, map.get(num) - 1);

            }


            return true;
        }

}
