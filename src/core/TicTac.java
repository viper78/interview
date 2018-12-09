package core;

import java.util.Scanner;

public class TicTac {

    static char[][] board = new char[3][3];
    static char player = 'x';

    public static void main(String[] args) {

        int row, col = -1;
        System.out.println("Board...");
        initialize(board);

        Scanner in = new Scanner(System.in);
        while (!isBoardFull(board) && !isGameOver(board)) {

            System.out.println("Enter row:");
            row = in.nextInt();
            System.out.println("Enter col:");
            col = in.nextInt();

            if (applyValue(board, row, col, player)) {
                print(board);
                if (!isGameOver(board)) {
                    switchPlayer();
                }
            }
        }

        print(board);
        if (!isGameOver(board) && isBoardFull(board)) {
            System.out.println("Its a tie");
        } else {
            System.out.println("Player " + player + " wins");
        }
    }

    public static boolean applyValue(char[][] board, int row, int col, char player) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == row && j == col) {
                    if (board[i][j] == '-') {
                        board[i][j] = player;
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return false;
    }

    public static void switchPlayer() {

        if (player == 'x') {
            player = 'o';
        } else {
            player = 'x';
        }
    }

    public static void initialize(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isBoardFull(char[][]board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isGameOver(char[][] board) {

        if (isRowsMatch(board) || isColsMatch(board) || isDiagonalsMatch(board)) {
            System.out.println("Game Over");
            return true;
        }
        return false;
    }

    public static boolean isRowsMatch(char[][] board) {

        for (int i = 0; i < 3; i++) {

            if (checkEquals(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isColsMatch(char[][] board) {

        for (int i = 0; i < 3; i++) {
            if (checkEquals(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDiagonalsMatch(char[][] board) {

        if (checkEquals(board[0][0], board[1][1], board[2][2]) || checkEquals(board[0][2], board[1][1], board[2][0])) {
            return true;
        }

        return false;
    }

    public static boolean checkEquals(char a, char b, char c) {

        if (a != '-' && a == b && b == c) {
            return true;
        }
        return false;
    }
}
