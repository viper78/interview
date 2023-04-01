package blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfpairsDivisibleBy60 {
    // time = [30,20,150,100,40]
    // time = [60,60,60]

    /**
     * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
     * You are given a list of songs where the ith song has a duration of time[i] seconds.
     *
     * Return the number of pairs of songs for which their total duration in seconds is divisible
     * by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
     * @param args
     */
    public static void main(String[] args) {
        int[] time = {60,30,20,150,100,40};
   //     int[] time = {60, 60, 60};
        System.out.println(numPairsDivisibleBy60(time));
    }
        public static int numPairsDivisibleBy60(int[] time) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int t: time) {
                if (t % 60 == 0) {
                    count += map.getOrDefault(0, 0);
                } else {
                    count += map.getOrDefault(60 - t%60, 0);
                }
                map.put(t%60, map.getOrDefault(t%60, 0) + 1);
            }
            return count;
        }


}
