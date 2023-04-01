package blind75;

public class MatrixDiagonalOrder {

    // https://leetcode.com/problems/diagonal-traverse/
    public int[] findDiagonalOrder(int[][] mat) {

        if (mat == null || mat.length == 0) return new int[0];

        int row = 0, col = 0;
        int m = mat.length;
        int n = mat[0].length;
        boolean up = true;
        int index = 0;

        int[] result = new int[m*n];

        while (row < m && col < n) {
            if (up) {
                while (row > 0 && col < n-1) {
                    result[index++] = mat[row][col];
                    row--;
                    col++;
                }
                result[index++] = mat[row][col];
                if (col == n-1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (row < m-1 && col > 0) {
                    result[index++] = mat[row][col];
                    row++;
                    col--;
                }
                result[index++] = mat[row][col];
                if(row == m-1) {
                    col++;
                } else {
                    row++;
                }
            }
            up = !up;
        }

        return result;
    }
}
