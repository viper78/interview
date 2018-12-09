package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {


    public static void main(String[] args) {


        int[] nums = {1, 1, 2, 2, 3, 4, 5};

        removeDupes(nums);
    }

    public static void removeDupes(int[] nums) {

        Arrays.sort(nums);

        List<Integer> result = new ArrayList();

        int prev = nums[0];
        result.add(prev);

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            if (prev != curr) {
                result.add(curr);
            }
            prev = curr;
        }

        result.stream().forEach(System.out::println);
    }
}
