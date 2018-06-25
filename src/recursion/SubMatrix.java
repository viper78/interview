package recursion;

import java.util.Arrays;

public class SubMatrix {

    public static void main(String[] args) {

        int[][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[1][0] = 1;
//        arr[1][1] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;
        System.out.println("Max:"+visit(arr));
    }

    private static int visit(int[][] arr) {

        int[][] solution = new int[3][3];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    int x = visit(arr, i, j, solution);
                    if (x > max) {
                        max = x;
                    }
                }
            }
        }
        return max;
    }

    private static int visit(int[][] arr, int i, int j, int[][] solution) {

        if (i < 0 || j < 0 || i == arr.length || j == arr.length) return 0;
        if (arr[i][j] == 0) return 0;

        if (solution[i][j] > 0) return solution[i][j];

        solution[i][j] = 1 + visit(arr, i+1, j, solution)
                + visit(arr, i, j+1, solution);
        return solution[i][j];
    }


}
