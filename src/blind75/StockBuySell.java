package blind75;

public class StockBuySell {
    public static void main(String[] args) {

        int[] stocks = new int[] {7,1,5,3,6,4};

        System.out.println(maxProfit(stocks));
    }

    public static int maxProfit(int[] prices) {

        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minValue)
                minValue = prices[i];
            if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }

        return maxProfit;
    }
}
