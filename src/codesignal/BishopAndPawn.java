package codesignal;

public class BishopAndPawn {
    boolean solution(String bishop, String pawn) {

        char bishop_x = bishop.charAt(0);
        char bishop_y = bishop.charAt(1);

        char pawn_x = pawn.charAt(0);
        char pawn_y = pawn.charAt(1);

        return Math.abs(bishop_x - pawn_x) == Math.abs(bishop_y - pawn_y);
    }

}
