package blind75;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        permute(nums, currentList, result);
        return result;
    }

    public static void permute(int[] nums, List<Integer> currentList, List<List<Integer>> result) {

        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int num: nums) {
            if (!currentList.contains(num)) {
                currentList.add(num);
                permute(nums, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
