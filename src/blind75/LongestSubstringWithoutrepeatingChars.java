package blind75;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutrepeatingChars {

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int result = 0;
        HashMap<Character, Integer> set = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (set.containsKey(c)) {
                if (left <= set.get(c)) {
                    left = set.get(c) + 1;
                }
            }
            set.put(c, right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
