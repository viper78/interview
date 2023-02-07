package blind75;

public class ReverseInteger {
    public int reverse(int x) {

        boolean negative = false;
        if ( x < 0) {
            negative = true;
            x *= -1;
        }

        long reversed = 0;
        while (x > 0) {
            reversed = (reversed * 10) + x%10;
            x /= 10;
        }
        if (negative) {
            reversed *= -1;
        }
        return (int)reversed;
    }
}
