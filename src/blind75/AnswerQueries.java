package blind75;

import java.util.Arrays;

public class AnswerQueries {

    /**
     * Given an integer array nums, an array queries where queries[i] = [x, y] and an integer limit,
     * return a boolean array that represents the answer to each query. A query is true if the sum of the
     * subarray from x to y is less than limit, or false otherwise.
     *
     * For example, given nums = [1, 6, 3, 2, 7, 2] and queries = [[0, 3], [2, 5], [2, 4]] and limit = 13,
     * the answer is [true, false, true]. For each query, the subarray sums are [12, 14, 12].
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][] queries = {{0, 3}, {2, 5}, {2, 4}};
        int limit = 13;

        boolean[] result = answerQueries(nums, queries, limit);
        System.out.println(result);
    }

    public static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {

        boolean[] result = new boolean[queries.length];
        int[] sumArray = new int[nums.length];

        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = sumArray[i-1] + nums[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            if (sumArray[y] - sumArray[x] + nums[x]  < limit) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
