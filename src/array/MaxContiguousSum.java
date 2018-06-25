package array;

public class MaxContiguousSum {

    public static void main(String[] args) {

        int[] num = {-2, 5, -1, 4, -3};

        System.out.println(contiguousSUm(num));
    }

    private static int contiguousSUm(int[] num) {

        int maxSum = 0, currentSum = 0;

        for (int i = 0; i < num.length; i++) {
            currentSum += num[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            } else if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
