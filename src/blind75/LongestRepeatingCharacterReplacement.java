package blind75;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
    public static int characterReplacement(String s, int k) {
        int start = 0;
        int maxOccurence = 0;
        int[] charCount = new int[26];
        int result = 0;

        for (int end = 0; end < s.length(); end++) {
            maxOccurence = Math.max(maxOccurence, ++charCount[s.charAt(end) - 'A']);
            if (end - start + 1 - maxOccurence > k) {
                charCount[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }

        return result;
    }
}
