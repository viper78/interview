package dynamic;

/**
 * Created by rajeshsubramanian on 2/19/18.
 */
public class CutRodMaxProfit {

    public static void main( String[] args ) {
        int[] rods = new int[]{1,2,3,4};
        int[] value = new int[]{2,5,7,8};
        int length = 5;

        int max = dynamic(rods, value, length);

        System.out.println(max);
    }

    private static int dynamic( int[] rods, int[] value, int length ) {

        int profit[][] = new int[value.length+1][length+1];

        for (int i=0; i<=value.length; i++) {
            for (int j=0; j<=length; j++) {
                if (i == 0 || j == 0) {
                    profit[i][j] = 0;
                    continue;
                }

                if (j < i) {
                    profit[i][j] = profit[i-1][j];
                } else {
                    int prev = profit[i-1][j];
                    int now = value[i-1] + profit[i][j-i];
                    profit[i][j] = Math.max( prev, now );
                }
                System.out.print(profit[i][j]+ " ");
            }
            System.out.println();
        }

        return profit[value.length][length];
    }
}
