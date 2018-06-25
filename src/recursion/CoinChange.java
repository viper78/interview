package recursion;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {10, 5, 1};
        int change = 16;

        System.out.println(makeChange(coins, change));
    }

    private static int makeChange(int[] coins, int change) {

        if (change == 0 ) return 0;

        int minCoins = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (change - coin >= 0) {
                int currentMin = makeChange(coins, change - coin);
                if (currentMin < minCoins) {
                    minCoins = currentMin;
                }
            }
        }
        return minCoins + 1;
    }

}
