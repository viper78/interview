package array;

public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "malayalam";

        System.out.println(longestPalindrome(str));
    }

    private static String longestPalindrome(String str) {

        if (str.isEmpty()) return null;

        if (str.length() == 1) return str;

        String longest = str.substring(0,1);

        for (int i = 0; i < str.length() - 1; i++) {

            String temp = longestPalindrome(str, i, i);
            if (temp.length() > longest.length()) {
                longest = temp;
            }

            temp = longestPalindrome(str, i, i+1);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }

        return longest;
    }

    private static String longestPalindrome(String str, int begin, int end) {

        while(begin >= 0 && end <= str.length() - 1 && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }

        return str.substring(begin + 1, end);
    }
}
