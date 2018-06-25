package string;

import java.util.Arrays;

/**
 * Created by rajeshsubramanian on 2/23/18.
 */
public class SubstringSearch_KMP {

    public static void main( String[] args ) {
        String text = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";

        System.out.println(bruteforce(text.toCharArray(), pattern.toCharArray()));
        System.out.println(kmp(text.toCharArray(), pattern.toCharArray()));
    }

    private static boolean kmp( char[] text, char[] pattern ) {
        int[] arr = computeArray(pattern);
        Arrays.stream( arr ).forEach( System.out::print );
        System.out.println();

        int i = 0;
        int j = 0;
        while ( i < text.length && j < pattern.length ) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = arr[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length)
            return true;
        return false;
    }

    private static int[] computeArray( char[] pattern ) {
        int[] arr = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length;) {
            if (pattern[index] == pattern[i]) {
                arr[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = arr[index - 1];
                } else {
                    arr[index] = 0;
                    i++;
                }
            }
        }

        return arr;
    }

    private static boolean bruteforce( char[] text, char[] pattern ) {
        int i = 0;
        int j = 0;
        int k = 0;

        while( i < text.length && j < pattern.length ) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
        }
        if (j == pattern.length)
            return true;

        return false;
    }

}
