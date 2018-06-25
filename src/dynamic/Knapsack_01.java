package dynamic;

/**
 * Created by rajeshsubramanian on 2/19/18.
 */
public class Knapsack_01 {

    public static void main( String[] args ) {

        int wt[] = new int[]{1,2,3,4,5};
        int val[] = new int[]{1,4,4,5,7};
        int total = 9;

        solve(val, wt, total);
    }

    private static void solve( int val[], int[] wt, int total ) {

        int matrix[][] = new int[val.length+1][total + 1];

        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= total; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                    continue;
                }
                if (wt[i-1] > j) {
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = Math.max( matrix[i-1][j], val[i-1] + matrix[i-1][j-i] );
                }

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}
