package blind75;

public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] output = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                output[i][j] = matrix[j][i];
            }
        }

        return output;
    }
}
