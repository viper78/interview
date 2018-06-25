package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {

        int[] num = {2,3,5,1};
        int target = 7;

        List<List<Integer>> result = new ArrayList<>();

        combinationSum(num, target, 0, result, new ArrayList());

        System.out.println(result);

    }

    private static void combinationSum(int[] num, int target, int start, List<List<Integer>> result, ArrayList current) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        if (start == num.length) return;

        current.add(num[start]);

        combinationSum(num, target - num[start], start, result, current);
        current.remove(current.size() - 1);
        combinationSum(num, target, start + 1, result, current);

    }
}
