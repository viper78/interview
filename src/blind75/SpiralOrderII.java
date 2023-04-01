package blind75;

public class SpiralOrderII {

    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int nums = 1;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                result[top][i] = nums++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = nums++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[bottom][i] = nums++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result[i][left] = nums++;
            }
            left++;
        }

        return result;
    }
}
