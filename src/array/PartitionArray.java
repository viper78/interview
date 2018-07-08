package array;

import java.util.Arrays;

public class PartitionArray {

    public static void main(String[] args) {

        int[] nums = {2,3,0,1,0,2,0};

        int[] result = moveZeros(nums);

        Arrays.stream(result).forEach(s-> System.out.print(s + " "));
    }

    private static int[] moveZeros(int[] nums) {

        int highIndex = nums.length - 1;
        int index = 0;

        while (index <= highIndex) {

            if (nums[index] == 0) {
                swap(nums, index, highIndex);
                highIndex--;
            } else {
                index++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
