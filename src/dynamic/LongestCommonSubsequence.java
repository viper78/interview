package dynamic;

public class LongestCommonSubsequence {

    // Non contiguous characters
    public static void main(String[] args) {

        String s1 = "abcdaf";
        String s2 = "zcbcf";

        System.out.println(longestSubsequence(s1.toCharArray(), s2.toCharArray()));
    }

    private static int longestSubsequence(char[] arr1, char[] arr2) {

        int[][] M = new int[arr1.length][arr2.length];
        String out="";

        if (arr1.length == 0 || arr2.length == 0) return 0;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {

                if (arr1[i] == arr2[j]) {
                    if ( i == 0 || j == 0) {
                        M[i][j] = 1;
                    } else {
                        M[i][j] = M[i - 1][j - 1] + 1;
                    }
                } else {
                    if ( i == 0 || j == 0) {
                        M[i][j] = 0;
                    } else {
                        M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
                    }
                }
                if (M[i][j] > out.length()) {
                    out += arr1[i];
                }
            }
        }

        System.out.println(out);

        return out.length();

    }
}
