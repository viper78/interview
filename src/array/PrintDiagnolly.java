package array;

public class PrintDiagnolly {

    static void printMatrixDiagonal(int mat[][]) {

        int m = mat.length;
        int n = mat[0].length;

        for (int k = 0; k <= m - 1; k++) {
            int i = k;
            int j = 0;

            while (i >= 0) {
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }
        }

        for (int k = 1; k <= n - 1; k++) {
            int i = m - 1;
            int j = k;

            while (j < n - 1) {
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }
        }
    }

    //Driver code
    public static void main (String[] args)
    {
        int mat[][] = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}};

        int n = 3;
        printMatrixDiagonal(mat);
    }
}
