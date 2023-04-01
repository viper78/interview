package blind75;

public class MatrixImageOverlap {

    // https://leetcode.com/problems/image-overlap/description/
    public int largestOverlap(int[][] img1, int[][] img2) {
        int N = img1.length;
        int M = img1[0].length;
        int maxOverlap = 0;

        for (int row = -N+1; row < N; row++) {
            for (int col = -M+1; col < M; col++) {
                maxOverlap = Math.max(maxOverlap, helper(img1, img2, row, col, N, M));
            }
        }

        return maxOverlap;
    }

    public int helper(int[][] img1, int[][] img2, int row, int col, int N, int M) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + row < 0 || i + row >= N || j + col < 0 || j + col >= M) {
                    continue;
                }
                if (img1[i][j] + img2[i+row][j+col] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
