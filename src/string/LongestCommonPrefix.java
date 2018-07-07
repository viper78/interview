package string;

public class LongestCommonPrefix {

    public static void main( String[] args ) {
        String[] arr = {"abcdefgh","abcefghijk","abcefgh"};

        String len = longest(arr);
        System.out.println(len);
    }

    private static String longest( String[] arr ) {

        if (arr == null || arr.length == 0) {
            return "";
        }
        if (arr.length == 1)
            return arr[0];

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            minLength = Math.min( minLength, arr[i].length() );
        }

        for (int i = 0; i < minLength; i++) {

            for (int j = 0; j < arr.length - 1; i++) {
                String s1 = arr[j];
                String s2 = arr[j+1];

                if (s1.charAt( i ) != s2.charAt( i )) {
                    return s1.substring( 0, i );
                }
            }
        }
        return arr[0].substring( 0, minLength );
    }

}
