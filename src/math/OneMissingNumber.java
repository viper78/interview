package math;

public class OneMissingNumber {

    public static void main(String[] args) {
        // Unsorted
        int[] nums = {1,2,3,6};

//        System.out.println(missingOneNumber(nums, 5));
        missingTwoNumbers(nums);

        // If sorted can use binary search in O(logn) time
        // Arthmetic progression

    }

    private static int missingOneNumber(int[] nums, int n) {

        int expectedTotal = 0;

        for (int i = n; i >=0; i--) {
            expectedTotal += i;
        }

        int actualTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            actualTotal += nums[i];
        }

        return Math.abs(expectedTotal - actualTotal);
    }

    private static void missingTwoNumbers(int[] nums) {

        int size = nums.length + 2;

        int totalSum = size * (size + 1)/2;
        int numSum = 0;
        for (int i : nums) {
            numSum += i;
        }

        int pivot = (int)(totalSum - numSum)/2;

        int totalXorLeft = 0;
        int totalXorRight = 0;
        int numXorLet = 0;
        int numXorRight = 0;

        for (int i = 1; i <= pivot; i++) {
            totalXorLeft ^= i;
        }
        for (int i = pivot + 1; i <= size; i++) {
            totalXorRight ^= i;
        }

        for (int i : nums) {
            if (i <= pivot) {
                numXorLet ^= i;
            } else {
                numXorRight ^= i;
            }
        }

        System.out.println(totalXorLeft ^ numXorLet);
        System.out.println(totalXorRight ^ numXorRight);

    }

}
