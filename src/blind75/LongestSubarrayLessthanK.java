package blind75;

public class LongestSubarrayLessthanK {
    public static void main(String[] args) {
        int[] nums = {3,4,2,1,9,0};
        int k = 7;

        int left = 0;
        int longest = 0;
        int currentSum = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            if (currentSum > k) {
                currentSum -= nums[left];
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        System.out.println(longest);

    }

}
