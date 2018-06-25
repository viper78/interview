package array;

public class NumberOfWaysMatrix {

    public static void main(String[] args) {
        int r = 3;
        int c = 2;

        System.out.println(noOfWays(r, c));
    }

    private static int noOfWays(int r, int c) {

        int[][] cache = new int[r][c];

        for (int i = 0; i < c; i++) {
            cache[0][i] = 1;
        }

        for (int i = 0; i < r; i++) {
            cache[i][0] = 1;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                cache[i][j] = cache[i-1][j] + cache[i][j-1];
            }
        }

        return cache[r-1][c-1];
    }
}
