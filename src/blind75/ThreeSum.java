package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] num =  {-1,0,1,2,-1,-4};

        System.out.println(threeSum(num));
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        // [-4,-1,-1,0,1,2]
        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || i > 0 && nums[i] != nums[i-1]) {

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {

                    int sum = 0 - nums[i];
                    if (nums[left] + nums[right] > sum) {
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return output;

    }
}
