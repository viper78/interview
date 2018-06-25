package dynamic;

/**
 * Created by rajeshsubramanian on 2/19/18.
 */
public class SubsetSum {

    public static void main( String[] args ) {

        int input[] = new int[]{2,3,7,8,10};
        int total = 11;

        subsetSum(input, total);
    }

    private static void subsetSum( int[] input, int total ) {

        boolean arr[][] = new boolean[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) {
            arr[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j < input[i-1]) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = arr[i-1][j] || arr[i-1][j - input[i-1]];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
