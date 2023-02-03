package blind75;

public class LongestPalindromeLength {

    public int longestPalindrome(String s) {
        int[] charCount = new int[128];
        int result = 0;
        for (Character curr: s.toCharArray()) {
            charCount[curr]++;
        }

        for (Integer count: charCount) {

            result += count /2 * 2;
            if (result % 2 == 0 && count % 2 == 1) {
                result += 1;
            }
        }

        return result;
    }
}
