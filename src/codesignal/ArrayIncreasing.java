package codesignal;

public class ArrayIncreasing {

    public static void main(String[] args) {
//        int[] sequence = {1,2,6,3,4};
        int[] sequence = {1,2,1,2};
        System.out.println(solve(sequence));
    }

    public static boolean solve(int[] sequence) {
        int count = 0;

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i-1] >= sequence[i] ) {
                count++;
                if (count > 1) return false;
                if (i > 1 && sequence[i] <= sequence[i-2]) {
                    sequence[i] = sequence[i-1];
                }
            }

        }
        return true;
    }
}
