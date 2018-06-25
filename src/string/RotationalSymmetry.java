package string;

public class RotationalSymmetry {
    public static void main( String[] args ) {

        String num = "89168";

        System.out.println(isRotationalSymmetric(num));

    }

    private static int getSymmetricPair(int digit) {
        int ans = -1;

        switch (digit) {

            case 0:
                ans = 0;
                break;
            case 1:
                ans = 1;
                break;
            case 6:
                ans = 9;
                break;
            case 8:
                ans = 8;
                break;
            case 9:
                ans = 9;
                break;
            default:
                ans = -1;

        }
        return ans;
    }

    private static boolean isRotationalSymmetric( String num ) {

        int low = 0;
        int high = num.length() - 1;

        while ( low <= high ) {

            int leftDigit = Integer.parseInt(num.charAt( low ) + "");
            int rightDigit = Integer.parseInt(num.charAt( high ) + "");

            if (getSymmetricPair( leftDigit ) != -1 && getSymmetricPair( rightDigit ) != -1) {
                low++;
                high--;
            } else {
                return false;
            }
        }

        return true;
    }
}
