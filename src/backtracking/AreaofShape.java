package backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajeshsubramanian on 2/22/18.
 */
public class AreaofShape {

    public static void main( String[] args ) {
        char[][] matrix=
                {

                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','R','R','R','R','0','0','0','0','0','0','0'},
                    {'0','0','R','0','0','R','0','0','0','R','R','0','0'},
                    {'0','0','R','R','R','R','0','0','0','R','R','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    {'0','0','0','0','0','0','0','0','0','0','0','0','0'},
                    };
        Map<String, Boolean> visited = new HashMap<>();
        System.out.println("Max Area:"+ traverse(matrix, visited));
    }

    private static int traverse( char[][] matrix, Map<String, Boolean> visited ) {
        int max_area = 0;
        int area = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'R' && visited.get( i+"_"+j ) == null) {
                    area = calculateArea(matrix, i, j, visited);
                    System.out.println("Current Area:"+area);
                    if (area > max_area) {
                        max_area = area;
                    }
                }
            }
        }
        return max_area;
    }

    private static int calculateArea( char[][] matrix, int i, int j, Map<String, Boolean> visited ) {

        if (i == 0 || j == 0 || i > matrix[0].length || j > matrix.length) {
            return 0;
        }
        if (matrix[i][j] != 'R') {
            return 0;
        }
        int area = 0;
        if (matrix[i][j] == 'R' && visited.get( i+"_"+j ) == null) {
            visited.put( i+"_"+j, true );
            area++;
            area = 1 + calculateArea( matrix, i-1, j, visited ) +  calculateArea( matrix, i, j-1, visited )
                    + calculateArea( matrix, i + 1, j, visited ) + calculateArea( matrix, i, j + 1, visited );
        }
        return area;
    }
}
