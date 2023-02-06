package codesignal;

public class ChessColorMatch {

    boolean solution(String cell1, String cell2) {
        char c1x = cell1.charAt(0);
        char c1y = cell1.charAt(1);

        char c2x = cell2.charAt(0);
        char c2y = cell2.charAt(1);

        return Math.abs(c2x - c1x) % 2 == Math.abs(c2y - c1y) % 2;

    }

}
