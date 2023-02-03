package blind75;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        subsets(nums, currentList, result, 0);

        return result;
    }

    public void subsets(int[] nums, List<Integer> currentList, List<List<Integer>> result, int index) {

        if (index > nums.length) {
            return;
        }

        result.add(new ArrayList<>(currentList));
        for (int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            subsets(nums, currentList, result, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
