package blind75;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] output = new int[N];

        int[] leftProducts = new int[N];
        int[] rightProducts = new int[N];

        leftProducts[0] = 1;
        rightProducts[N-1] = 1;

        for (int i = 1; i < N; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i-1];
        }

        for (int i = N - 2; i >= 0; i--) {
            rightProducts[i] = nums[i+1] * rightProducts[i+1];
        }

        for (int i = 0; i < N; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }

        return output;
    }
}
