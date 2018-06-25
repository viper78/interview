package math;

public class ReverseInteger {

    public static void main(String[] args) {

        int x = 1234;
        int out = 0;
        int rem, result = 0;

        while (x > 0) {
            rem = x % 10;
            x = x/10;
            result = result*10 + rem;
        }
        System.out.println(result);

        System.out.println(reverseString( "rajesh".toCharArray()));
    }

    private static String reverseString( char[] arr) {

        StringBuffer buffer = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            buffer.append(arr[i]);
        }

        return buffer.toString();
    }


}
