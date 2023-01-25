package blind75;

import java.util.Arrays;

public class TwoSumSorted {

    public static void main(String[] args) {
        int[] numbers = {-3,-2,4,5,6};
        int target = 3;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] {arr[left], arr[right]};
            }
        }

        return new int[]{0,0};
    }
}
