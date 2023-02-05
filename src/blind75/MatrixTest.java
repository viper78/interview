package blind75;

public class MatrixTest {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,0},
                          {0,5,0,1},
                          {2,1,3,10}};

        System.out.println(solution(matrix));
    }
    public static int solution(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int total = 0;

        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                if (matrix[i][j] == 0) {
                    break;
                }
                total += matrix[i][j];
            }
        }

        return total;

    }
}
