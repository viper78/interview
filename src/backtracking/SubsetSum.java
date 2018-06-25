package backtracking;

import java.util.Arrays;

public class SubsetSum {

    int[] input;
    int targetSum;

    public static void main(String[] args) {

        SubsetSum subsetSum = new SubsetSum();
        subsetSum.findSubsets();

    }

    private void findSubsets() {
        input = new int[]{ 2, 3, 4, 5 };
        targetSum = 7;
        int size = input.length;
        int[] selected = new int[size];
        int sumOfRemaning = Arrays.stream(input).sum();

        backtrack(input, selected, 0, 0, sumOfRemaning);
    }

    private void backtrack(int[] input, int[] selected, int sumOfSelected, int index, int sumOfRemaning) {
        selected[index] = 1;

        if (sumOfSelected + input[index] == targetSum) {
            for (int i = 0; i < input.length; i++) {
                if (selected[i] != 0) {
                    System.out.print(input[i] + " ");
                }
            }
            System.out.println();
        }



        if ((index + 1 < input.length) && (sumOfSelected + input[index] ) <= targetSum) {
            backtrack(input, selected, sumOfSelected + input[index], index + 1, sumOfRemaning - input[index]);
        }

        selected[index] = 0;

        if ((index + 1 < input.length) && (sumOfSelected + sumOfRemaning - input[index + 1] >= targetSum)) {
            backtrack(input, selected, sumOfSelected, index + 1, sumOfRemaning - input[index]);
        }
    }
}
