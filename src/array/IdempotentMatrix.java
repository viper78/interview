package array;

public class IdempotentMatrix {

    static int N = 3;

    public static void main (String[] args)
    {
        int mat[][] = {{2, -2, -4},
                {-1, 3, 4},
                {1, -2, -3}};

        // checkIdempotent function call.
        if (checkIdempotent(mat))
            System.out.println( "Idempotent Matrix");
        else
            System.out.println("Not Idempotent Matrix.");

    }

    static boolean checkIdempotent(int mat[][])
    {
        // Calculate multiplication of matrix
        // with itself and store it into res.
        int res[][] = new int[N][N];
        multiply(mat, res);

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mat[i][j] != res[i][j])
                    return false;
            }
        }
        return true;
    }

    static void multiply(int mat[][], int res[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                res[i][j] = 0;
                for (int k = 0; k < N; k++)
                    res[i][j] += mat[i][k] * mat[k][j];
            }
        }
    }

}
