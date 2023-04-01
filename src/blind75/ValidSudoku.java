package blind75;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + "R" + i) ||
                            !seen.add(number + "C" + j) ||
                            !seen.add(number + "B" + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
}
