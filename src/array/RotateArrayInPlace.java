package array;

public class RotateArrayInPlace {

    public static void main(String[] args) {
        int[][] mat = { {1, 2, 3, 4},
                        {2, 5, 6, 7},
                        {8, 6, 5, 3},
                        {9, 2, 4, 5}};

        int N = mat.length;

        rotateArray(mat, N);

        displayMatrix(N, mat);
    }

    private static void rotateArray(int[][] mat, int N) {

        for (int x = 0; x < N / 2; x++)
        {
            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < N-1-x; y++)
            {
                // store current cell in temp variable
                int temp = mat[x][y];

                // move values from right to top
                mat[x][y] = mat[y][N-1-x];

                // move values from bottom to right
                mat[y][N-1-x] = mat[N-1-x][N-1-y];

                // move values from left to bottom
                mat[N-1-x][N-1-y] = mat[N-1-y][x];

                // assign temp to left
                mat[N-1-y][x] = temp;
            }
        }
    }

    static void displayMatrix(int N, int mat[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }


}
