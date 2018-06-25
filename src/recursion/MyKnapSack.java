package recursion;

import java.util.Arrays;

public class MyKnapSack {

    public static void main(String[] args) {

        Item[] items = new Item[3];
        items[0] = new Item(6, 2);
        items[1] = new Item(10, 2);
        items[2] = new Item(12, 3);

        int maxWeight = 5;

        int[] solution = new int[maxWeight + 1];
        Arrays.fill(solution, -1);

        System.out.println(knapsack(items, maxWeight, solution));

    }

    private static int knapsack(Item[] items, int maxWeight, int[] solution) {

        if (maxWeight == 0) return 0;

        int maxValue = Integer.MIN_VALUE;

        if (solution[maxWeight] > -1) return solution[maxWeight];

        for (Item item : items) {
            if (maxWeight - item.weight >= 0) {
                int currValue = item.value + knapsack(items, maxWeight - item.weight, solution);
                if (currValue > maxValue) {
                    maxValue = currValue;
                }
//                maxValue = Math.max(maxValue, currValue);
            }
        }
        solution[maxWeight] = maxValue;
        return solution[maxWeight];

    }


    private static class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
