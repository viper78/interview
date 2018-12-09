package string;

public class Palindrome {

    public static void main(String[] args) {

        String str = "malayyalam";

        System.out.println( isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {

        int i = 0;
        int j = str.length() - 1;
        int k = str.length()/2;

        for (int index = i; index <= k; index++ ) {

            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
