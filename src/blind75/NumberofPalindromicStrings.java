package blind75;

public class NumberofPalindromicStrings {
    int result = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i+1);
        }
        return result;
    }

    public void count(String str, int begin, int end) {
        while (begin >=0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
            result++;
        }
    }
}
