package recursion;

import java.util.Arrays;

public class RobotGrid {

    public static void main(String[] args) {
        // No of ways tp get to (4,4) grid
        int m = 100;
        int n = 100;

        int[][] helper = new int[m+1][n+1];
        System.out.println(noOfPaths(m, n, helper));

        //System.out.println(naiveRecursion(m, n));
    }

    private static int noOfPaths(int m, int n, int[][] helper) {

        if (helper[m][n] != 0) {
            return helper[m][n];
        }
        if (m == 0 && n == 0) {
            helper[m][n] = 0;
        } else if (m == 0 || n == 0) {
            helper[m][n] = 1;
        } else {
            helper[m][n] = noOfPaths(m, n-1, helper) + noOfPaths(m-1, n, helper);
        }

        return helper[m][n];
    }

    private static int naiveRecursion(int m, int n) {

        if (m == 0 && n == 0) {
            return 0;
        } else if (m == 0 || n == 0) {
            return 1;
        } else {
            return naiveRecursion(m-1, n) + naiveRecursion(m, n-1);
        }
    }


}
