package recursion;

public class MyRodCutting {

    public static void main(String[] args) {
        int length = 5;
        Rod[] rods = new Rod[4];
        rods[0] = new Rod(1, 2);
        rods[1] = new Rod(2, 5);
        rods[2] = new Rod(3, 7);
        rods[3] = new Rod(4, 8);

        int[] cache = new int[length + 1];

        System.out.println(maxProfit(rods, length, cache));

    }

    private static int maxProfit(Rod[] rods, int L, int[] cache) {

        if (L == 0) return 0;

        int max = Integer.MIN_VALUE;

        if (cache[L] > 0) return cache[L];

        for (Rod rod : rods) {
            if (L - rod.length >= 0) {
                int currValue = rod.price + maxProfit(rods, L - rod.length, cache);
                if (currValue > max) {
                    max = currValue;
                }
            }
        }
        cache[L] = max;
        return cache[L];
    }

    static class Rod {
        int length;
        int price;

        Rod(int length, int price) {
            this.length = length;
            this.price = price;
        }
    }
}
