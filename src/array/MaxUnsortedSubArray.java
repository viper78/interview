package array;

public class MaxUnsortedSubArray {

    public static void main(String[] args) {

        int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};

        findRange(arr);
    }

    private static void findRange(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i+1]) {
                start = i;
                break;
            }
        }

        if (start == nums.length - 1) {
            System.out.println("Already sorted");
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < nums[i-1]) {
                end = i;
                break;
            }
        }

        int min = nums[start];
        int max = nums[end];

        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < start; i++) {
            if (min < nums[i]) {
                start = i;
                break;
            }
        }

        for (int i = nums.length - 1; i > end; i--) {
            if (max > nums[i]) {
                end = i;
                break;
            }
        }

        System.out.println("Start: " + start + " end: " + end);
    }
}
