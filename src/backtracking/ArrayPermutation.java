package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayPermutation {

    // Time - O(n!)
    public static void main( String[] args ) {
        int[] nums = new int[]{1,2,3};
        ArrayPermutation ap = new ArrayPermutation();
        List<List<Integer>> result = ap.permute(nums );

        System.out.println(result);
    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        permute(nums, 0, result);

        return result;
    }

    private void permute(int[] nums, int start, List<List<Integer>> result) {

        if (start >= nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

