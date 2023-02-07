package blind75;

public class ReverseBits {

    public static void main(String[] args) {

        int n = 8;//1000
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }
        System.out.println(result);
        System.out.println(Integer.toBinaryString(result));
    }
}
