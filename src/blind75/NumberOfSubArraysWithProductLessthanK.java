package blind75;

public class NumberOfSubArraysWithProductLessthanK {

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        int result = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            if (product >= k) {
                product = product/nums[left];
                left++;
            }
            int len = right - left + 1;
            result += len;

        }
        System.out.println(result);
    }
}
