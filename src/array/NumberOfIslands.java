package array;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'0','0','0','0','0','0'},
                {'0','X','X','0','0','0'},
                {'0','X','X','0','0','0'},
                {'0','0','0','0','X','0'},
                {'0','0','X','0','0','0'}};

        System.out.println(numofIslands(grid));
    }

    private static int numofIslands(char[][] grid) {

        int count = 0;
        for(int r = 0; r < grid.length ; r++) {
            for (int c = 0; c < grid[0].length ; c++) {
                if (grid[r][c] == 'X') {
                    visitIsland(r, c, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private static void visitIsland(int r, int c, char[][] grid) {

        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 'X') {

            grid[r][c] = 'v';
            visitIsland(r+1, c, grid);
            visitIsland(r-1, c, grid);
            visitIsland(r, c+1, grid);
            visitIsland(r, c-1, grid);
        }
    }
}
