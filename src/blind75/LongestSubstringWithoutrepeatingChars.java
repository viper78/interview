package blind75;

import java.util.HashSet;

public class LongestSubstringWithoutrepeatingChars {

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {

        int left = 0;
        int result = 0;
        HashSet<Character> set = new HashSet<Character>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
