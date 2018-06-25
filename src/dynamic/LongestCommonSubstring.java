package dynamic;

public class LongestCommonSubstring {

    // Common Contiguous string
    public static void main(String[] args) {

        String s1 = "abab";
        String s2 = "abba";

        System.out.println(longestCommonSubstring(s1.toCharArray(), s2.toCharArray()));
    }

    private static String longestCommonSubstring(char[] arr1, char[] arr2) {

        int[][] M = new int[arr1.length][arr2.length];
        String out = "";

        if (arr1.length == 0 || arr2.length == 0) return out;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    if (i == 0 || j == 0) {
                        M[i][j] = 1;
                    } else {
                        M[i][j] = M[i-1][j-1] + 1;
                    }
                    if (M[i][j] > out.length()) {
                        out += arr1[i];
                    }
                }
            }
        }

        return out;
    }
}
