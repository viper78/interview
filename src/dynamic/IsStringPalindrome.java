package dynamic;

/**
 * Created by rajeshsubramanian on 3/14/18.
 */
public class IsStringPalindrome {

    public static void main(String[] args) {
        String pali = "Ratzs live on no evil starz";
        //System.out.println(isPermutationOfPalindrome(pali));
        String pali2 = "Zeus was deified saw Suez";
        System.out.println(isPermutationOfPalindrome(pali2));
    }

    private static boolean isPermutationOfPalindrome( String str ) {

        int i = 0;
        int begin = 0;
        int end = str.length() - 1;
        int middle = (end - begin)/2;

        for (i = begin; i <=middle; i++) {
            if (getCharValue(str.charAt( begin )) == getCharValue(str.charAt( end ))) {
                begin++;
                end--;
            } else {
                break;
            }
        }
        if (i == middle + 1)
            return true;

        return false;
    }

    private static int getCharValue(char character) {

        int a = Character.getNumericValue( 'a' );
        int A = Character.getNumericValue( 'A' );
        int z = Character.getNumericValue( 'z' );

        int val = Character.getNumericValue( character );

        if ( a <= val && val <= z) {
            return val;
        } else {
            return val + (A-a);
        }
    }

}
