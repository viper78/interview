package blind75;

public class MinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        while (left <= right) {
            int midpoint = (left + right)/2;
            if (midpoint < right-1 && nums[midpoint] > nums[midpoint + 1]) {
                return nums[midpoint + 1];
            } else if (nums[left] < nums[midpoint] && nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return nums[left];
    }
}
