package string;

public class MinCharacterPalindrome {

    public static void main( String[] args ) {

        String str = "ABC";

        int min = minChars(str);

        System.out.println(min);
    }

    private static int minChars( String str ) {

        int count = 0;
        boolean flag = false;

        while (str.length() > 0) {

            if (isPalindrome(str)) {
                flag = true;
                break;
            } else {
                count++;
                str = str.substring( 0, str.length() - 1 );
            }
        }

        if (flag) {
            return count;
        }

        return -1;
    }

    private static boolean isPalindrome( String str ) {

        int low = 0;
        int high = str.length() -1 ;

        while (low < high) {
            if (str.charAt( low ) != str.charAt( high ))
                return false;
        }
        return true;
    }
}
