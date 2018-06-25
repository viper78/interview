package array;

public class NumberOfOnesInBinary {

    public static void main(String[] args) {

        int x = 14;
        int sum = 0;

        while ( x > 0) {
            // looking at the lowest bit and performing a bitwise AND
            sum += x & 1;
            // shift one position to right
            x >>= 1;
        }

        System.out.println(sum);
    }
}
