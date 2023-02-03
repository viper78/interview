package blind75;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] input = {1,2,3,4,5,6,7,8,9};
        List<Integer> currentList = new ArrayList<>();

        backtrack(input, k, n, 0, 0, currentList, result);
        return result;
    }

    public void backtrack(int[] input, int length, int totalSum, int currentSum, int index, List<Integer> currentList, List<List<Integer>> result) {


        if (currentList.size() == length && currentSum == totalSum) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < input.length; i++) {
            int num = input[i];
            if (currentSum + num <= totalSum) {
                currentList.add(num);
                backtrack(input, length, totalSum, currentSum + num, i + 1, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
