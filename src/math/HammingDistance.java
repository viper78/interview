package math;

public class HammingDistance {

    public static void main(String[] args) {


        int x = 4;
        int y = 1;

        int result = x^y;
        int count = 0;

        while (result > 0) {
            count += result & 1;
            result >>= 1;
        }

        System.out.println(count);
    }
}
