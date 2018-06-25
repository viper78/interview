package dynamic;

/**
 * Created by rajeshsubramanian on 3/14/18.
 */
public class LongestPalindromeSubstring {

    public static void main(String args[]){
        System.out.println(longestpalindrome("abba".toCharArray()));
    }

    private static int longestpalindrome( char[] str ) {
        boolean[][] T = new boolean[str.length][str.length];

        for (int i = 0; i < str.length; i++) {
            T[i][i] = true;
        }
        int max = 1;

        for (int l=2; l <= str.length; l++) {
            for (int i = 0; i < str.length - l + 1; i++) {
                int len = 0;
                int j = i + l-1;
                if (l == 2) {
                    if (str[i] == str[j]) {
                        T[i][j] = true;
                        len = 2;
                    }
                } else {
                    if (str[i] == str[j] && T[i+1][j-1]) {
                        T[i][j] = true;
                        len = j -i + 1;
                    }
                }
                if (len > max) {
                    max = len;
                }
            }
        }
        return max;
    }
}
