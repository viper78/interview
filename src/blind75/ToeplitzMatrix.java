package blind75;

public class ToeplitzMatrix {
    //https://leetcode.com/problems/toeplitz-matrix/
    public boolean isToeplitzMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i-1][j-1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
