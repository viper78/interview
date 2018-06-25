package recursion;

import java.util.Arrays;

public class MyCoinChange {

    public static void main(String[] args) {

        int[] coins = {10, 5, 1};
        int k = 16;
        int[] solution = new int[k + 1];
        Arrays.fill(solution, -1);

        System.out.println(makeChange(coins, k, solution));
    }

    private static int makeChange(int[] coins, int change, int[] solution) {

        if (change == 0) return 0;
        int min = Integer.MAX_VALUE;
        if (solution[change] != -1) return solution[change];
        for (int coin : coins) {
            if (change - coin >= 0) {
                int currmin = 1 + makeChange(coins, change - coin, solution);
                if (currmin < min) {
                    min = currmin;
                }
            }
        }
        solution[change] = min;
        return solution[change];
    }
}
