package blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        String s ="eceba";
        int k = 2;

        int longest = 0;
        int left = 0;
        HashMap<Character, Integer> counts = new HashMap<>();


        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            counts.put(curr, counts.getOrDefault(curr, 0)+ 1);
            if (counts.size() > k) {
                counts.remove(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                if (counts.get(s.charAt(left)) == 0) {
                    counts.remove(s.charAt(left));
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        System.out.println(longest);
    }
}
