package blind75;

public class MaxAverageInArray {

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
    }
    public double findMaxAverage(int[] nums, int k) {

        double currentAvg = 0;
        double maxAvg = 0;
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        currentAvg = currentSum/k;
        maxAvg = currentAvg;

        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i-k] + nums[i];
            currentAvg = currentSum/k;
            maxAvg = Math.max(maxAvg, currentAvg);
        }
        return maxAvg;
    }
}
