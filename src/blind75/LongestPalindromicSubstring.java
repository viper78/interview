package blind75;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "malayalam";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {

        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;

        String longest = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            String l1 = getPalindrome(s, i, i);
            String l2 = getPalindrome(s, i, i+1);

            String temp = l1.length() > l2.length() ? l1 : l2;
            longest = longest.length() > temp.length() ? longest : temp;
        }

        return longest;
    }

    public static String getPalindrome(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        return str.substring(begin + 1, end);
    }
}
