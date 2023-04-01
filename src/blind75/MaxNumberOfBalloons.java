package blind75;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {

    // https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/705/hashing/4663/
    public int maxNumberOfBalloons(String text) {
        String str = "balloon";
        int count = 0;
        int min = Integer.MAX_VALUE;

        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for (char curr: text.toCharArray()) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        Map<Character, Integer> bmap = new HashMap<Character, Integer>();
        for (char curr: str.toCharArray()) {
            bmap.put(curr, bmap.getOrDefault(curr, 0) + 1);
        }

        for (char c: str.toCharArray()) {
            if (map.get(c) == null) {
                min = 0;
            } else {
                min = Math.min(min, map.get(c)/bmap.get(c));
            }
        }

        return min;
    }
}
