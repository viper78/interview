package backtracking;

public class MazeProblem {

    public static void main(String[] args) {

        int[][] mazeTable = {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int size = mazeTable.length;
        int[][] solutionTable = new int[size][size];

        if (solve(0, 0, mazeTable, solutionTable, size)) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (solutionTable[i][j] == 1) {
                        System.out.print("S");
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println(" No Solution...");
        }

    }

    private static boolean solve(int row, int col, int[][] mazeTable, int[][] solutionTable, int size) {

        if (row == size -1 && col == size -1) {
            solutionTable[row][col] = 1;
            return true;
        }

        if (isValid(row, col, mazeTable, size)) {

            solutionTable[row][col] = 1;

            if (solve(row + 1, col, mazeTable, solutionTable, size)) {
                return true;
            }

            if (solve(row, col + 1, mazeTable, solutionTable, size)) {
                return true;
            }

            if (solve(row, col -1, mazeTable, solutionTable, size)) {
                return true;
            }

            if (solve(row + 1, col, mazeTable, solutionTable, size)) {
                return true;
            }

            solutionTable[row][col] = 0;
        }
        return false;
    }

    private static boolean isValid(int row, int col, int[][] mazeTable, int size) {
        if (row < 0 || row >= size) return false;

        if (col < 0 || col >= size) return false;

        if (mazeTable[row][col] != 1) return false;

        return true;
    }
}
