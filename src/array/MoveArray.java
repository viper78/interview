package array;

import java.util.Arrays;

public class MoveArray {

    public static void main(String[] args) {

        int[] nums = {0, 1, 1, 0, 1, 0};

        int[] result = moveZeros(nums);
        Arrays.stream(result).forEach(s-> System.out.print(s + " "));
    }

    private static int[] moveZeros(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
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
