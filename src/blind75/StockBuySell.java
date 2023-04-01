package blind75;

public class StockBuySell {
    public static void main(String[] args) {

        int[] stocks = new int[] {7,1,5,3,6,4};

        System.out.println(maxProfit(stocks));
    }

    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            maxProfit = Math.max(maxProfit, p - minPrice);
        }

        return maxProfit;
    }
}
