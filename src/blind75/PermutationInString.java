package blind75;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1_count = new int[26];
        int[] s2_count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1_count[s1.charAt(i) - 'a']++;
            s2_count[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (Arrays.equals(s1_count, s2_count)) {
                return true;
            }
            s2_count[s2.charAt(left) - 'a']--;
            s2_count[s2.charAt(right) - 'a']++;
            left++;
        }
        if (Arrays.equals(s1_count, s2_count)) {
            return true;
        }

        return false;

    }
}
