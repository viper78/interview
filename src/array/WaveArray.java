package array;

import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {

        int[] nums = {3,6,5,10,7,20};

        int[] result = waveArray(nums);

        Arrays.stream(result).forEach(s-> System.out.print(s + " "));
    }

    private static int[] waveArray(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            swap(nums, i, i+1);
        }

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
