package contest.leetcode20210807;

/**
 * You are given a 0-indexed 8 x 8 grid board, where board[r][c] represents the cell (r, c) on a game board. On the board, free cells are represented by '.', white cells are represented by 'W', and black cells are represented by 'B'.
 *
 * Each move in this game consists of choosing a free cell and changing it to the color you are playing as (either white or black). However, a move is only legal if, after changing it, the cell becomes the endpoint of a good line (horizontal, vertical, or diagonal).
 *
 * A good line is a line of three or more cells (including the endpoints) where the endpoints of the line are one color, and the remaining cells in the middle are the opposite color (no cells in the line are free). You can find examples for good lines in the figure below:
 *
 * Given two integers rMove and cMove and a character color representing the color you are playing as (white or black), return true if changing cell (rMove, cMove) to color color is a legal move, or false if it is not legal.
 */
public class CheckIfMoveIsLegal {
    int[][] directions = new int[][] {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        for (int[] d : directions) {
            System.out.println("d0 = " + d[0] + ", d1 = " + d[1] + ", res = " + checkLine(board, d, rMove, cMove, color));
            if (checkLine(board, d, rMove, cMove, color)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLine(char[][] board, int[] d, int rMove, int cMove, char color) {
        int r = rMove, c = cMove;
        int count = 0;
        boolean midValid = true;
        while (inBoard(board, r, c)) {
            r = r + d[0];
            c = c + d[1];
            if (inBoard(board, r, c)) {
                if (board[r][c] == '.') {
                    midValid = false;
                    break;
                } else if (board[r][c] == color) {
                    midValid = count >= 1;
                    break;
                } else {
                    count++;
                }
            } else {
                break;
            }
        }

        return midValid && count >= 1 && inBoard(board, r, c) && color == board[r][c];
    }

    private boolean inBoard(char[][] board, int r, int c) {
        return r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[0].length - 1;
    }

    /**
     *
     [['.','.','.','.','.','.','.','.'],
     ['.','B','.','.','W','.','.','.'],
     ['.','.','W','.','.','.','.','.'],
     ['.','.','.','W','B','.','.','.'],
     ['.','.','.','.','.','.','.','.'],
     ['.','.','.','.','B','W','.','.'],
     ['.','.','.','.','.','.','W','.'],
     ['.','.','.','.','.','.','.','B']]
     * @param args
     */

    public static void main(String[] args) {
        CheckIfMoveIsLegal ch = new CheckIfMoveIsLegal();
//        char[][] board = new char[][] {
//                {'.','.','W','.','B','W','W','B'},{'B','W','.','W','.','W','B','B'},{'.','W','B','W','W','.','W','W'},{'W','W','.','W','.','.','B','B'},{'B','W','B','B','W','W','B','.'},{'W','.','W','.','.','B','W','W'},{'B','.','B','B','.','.','B','B'},{'.','W','.','W','.','W','.','W'}
//        };
        char[][] board = new char[][] {
                {'.','.','.','.','.','.','.','.'},
                {'.','B','.','.','W','.','.','.'},
                {'.','.','W','.','.','.','.','.'},
                {'.','.','.','W','B','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','B','W','.','.'},
                {'.','.','.','.','.','.','W','.'},
                {'.','.','.','.','.','.','.','B'}
        };

        System.out.println(ch.checkMove(board, 4, 4, 'W'));
    }
}
