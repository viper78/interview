package array;

import java.util.Arrays;

public class SwapZeros {

    public static void main(String[] args) {

        int[] nums = {-1,0,6,3,-2,0,1,0};

        int n = nums.length;

        int low = 0;
        int high = n-1;
        int index = 0;

        while (index <= high) {
            if (nums[index] != 0) {
                swap(nums, low, index);
                low++;
                index++;
            } else {
                swap(nums, index, high);
                high--;
            }
        }

        Arrays.stream(nums).forEach( s-> System.out.print(s + " "));

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
