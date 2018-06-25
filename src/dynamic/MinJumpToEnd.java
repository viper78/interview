package dynamic;

import java.util.Arrays;

public class MinJumpToEnd {

    public static void main(String[] args) {
        int[] num = {1,1,4,1,2,0,1};

        System.out.println(minJump(num));
    }

    private static int minJump(int[] num) {

        int[] jumps = new int[num.length];
        int[] result = new int[num.length];

        for (int i = 1; i < jumps.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if (num[j] +j >= i) {
                    if (jumps[i] > jumps[j] + 1) {
                        jumps[i] = jumps[j] + 1;
                        result[i] = j;
                    }
                }
            }
        }
        return jumps[jumps.length - 1];
    }
}
