package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] num = {1, 0, -1, 0, -2, 2};
        int target = 0;

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

        int prev = -1;
        for (int i = start; i < num.length; i++) {
            if (prev != num[start]) {
                current.add(num[i]);
                combinationSum(num, target - num[i], start + 1, result, current);
                current.remove(current.size() - 1);
                prev = num[start];
            }
        }
    }
}
