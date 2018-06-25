package array;

public class NumberOfContinuousIslands {

    static int count = 0;
    public static void main(String[] args) {
        char[][] grid = {{'0','0','0','0','0','0'},
                        {'X','X','X','0','0','0'},
                        {'X','X','X','0','0','0'},
                        {'0','0','0','0','X','0'},
                        {'0','0','X','0','0','0'}};

        System.out.println(numofIslands(grid));
    }

    private static int numofIslands(char[][] grid) {

        int max = Integer.MIN_VALUE;
        for(int r = 0; r < grid.length ; r++) {
            for (int c = 0; c < grid[0].length ; c++) {
                if (grid[r][c] == 'X') {
                  visitIsland(r, c, grid);
                  max = Math.max(max, count);
                  count = 0;
                }
            }

        }

        return max;
    }

    private static void visitIsland(int r, int c, char[][] grid) {

        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 'X') {

            grid[r][c] = 'm';
            count++;
            visitIsland(r+1, c, grid);
            visitIsland(r-1, c, grid);
            visitIsland(r, c+1, grid);
            visitIsland(r, c-1, grid);
        }
    }
}
