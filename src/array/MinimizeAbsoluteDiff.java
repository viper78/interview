package array;

import java.util.Arrays;
import java.util.List;

public class MinimizeAbsoluteDiff {

    public static void main(String[] args) {
        MinimizeAbsoluteDiff minimizeAbsoluteDiff = new MinimizeAbsoluteDiff();
        List<Integer> A =  Arrays.asList( 1, 4, 5, 8, 20 );
        List<Integer> B =  Arrays.asList( 6, 9, 15 );
        List<Integer> C =  Arrays.asList( 2, 3, 6, 6 );
        System.out.println(minimizeAbsoluteDiff.solve(A, B, C));
    }

    public int solve(List<Integer> A, List<Integer> B, List<Integer> C) {
        int k = 0;
        int i = 0;
        int j = 0;
        long min = Long.MAX_VALUE;
        while (i < A.size() && j < B.size() && k < C.size()) {
            int a = A.get(i);
            int b = B.get(j);
            int c = C.get(k);
            long mad = mad(a, b, c);
            if (mad == 0) return 0;
            if (mad < min) {
                min = mad;
            }
            int min_abc = min(a, b, c);
            if (min_abc == a) {
                i++;
            } else if (min_abc == b) {
                j++;
            } else {
                k++;
            }
        }
        return (int) min;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private long mad(int a, int b, int c) {
        return Math.abs(((long) max(a, b, c)) - min(a, b, c));
    }

}
