package blind75;

public class MinSubarraySum {

    public static void main(String[] args) {

    }
    public int minSubArrayLen(int target, int[] nums) {

        int shortest = nums.length;
        int left = 0; int right;
        int currentSum = 0;

        for (right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                shortest = Math.min(shortest, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        return shortest >= nums.length ? 0 : shortest;
    }
}
