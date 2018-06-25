package dynamic;

/**
 * Created by rajeshsubramanian on 2/19/18.
 */
public class EggDrop {

    public static void main( String[] args ) {
        int eggs = 3;
        int floors = 10;

        eggDrop( eggs, floors );
    }

    private static void eggDrop( int eggs, int floors ) {

        int arr[][] = new int[eggs + 1][floors + 1];

        for (int j = 0; j <=floors; j++) {
            arr[1][j] = j;
        }

        for ( int i = 2; i <= eggs; i++ ) {
            for ( int j = 1; j <= floors; j++ ) {
                arr[i][j] = Integer.MAX_VALUE;
                for ( int k = 1; k <= j; k++ ) {
                    int val = 1 + Math.max( arr[i - 1][j - 1], arr[i][j - k] );
                    if ( val < arr[i][j] ) {
                        arr[i][j] = val;
                    }
                }
            }
        }
        System.out.println(arr[eggs][floors]);
    }
}

