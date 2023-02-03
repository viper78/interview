package blind75;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList();

        combination(candidates, target, 0, 0, current, result);

        return result;
    }

    public void combination(int[] candidates, int target, int index, int currentSum, List<Integer> current, List<List<Integer>> result) {

        if (currentSum == target) {
            result.add(new ArrayList<>(current));
        }

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if (currentSum + num <= target) {
                current.add(num);
                combination(candidates, target, i, currentSum + num, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
