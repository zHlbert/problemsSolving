package leetcode._1222;

import java.util.ArrayList;
import java.util.List;

public class QueensThatCanAttackTheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] board = new boolean[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = king[0] - 1; i >= 0; i--) {
            if (board[i][king[1]]) {
                add2List(i, king[1], res);
                break;
            }
        }
        for (int i = king[0] + 1; i < 8; i++) {
            if (board[i][king[1]]) {
                add2List(i, king[1], res);
                break;
            }
        }
        for (int i = king[1] - 1; i >= 0; i--) {
            if (board[king[0]][i]) {
                add2List(king[0], i, res);
                break;
            }
        }
        for (int i = king[1] + 1; i < 8; i++) {
            if (board[king[0]][i]) {
                add2List(king[0], i, res);
                break;
            }
        }
        for (int i = king[0] - 1; i >= 0; i--) {
            int y = i - king[0] + king[1];
            if (y < 0) break;
            if (board[i][y]) {
                add2List(i, y, res);
                break;
            }
        }
        for (int i = king[0] + 1; i < 8; i++) {
            int y = i - king[0] + king[1];
            if (y >= 8) break;
            if (board[i][y]) {
                add2List(i, y, res);
                break;
            }
        }
        for (int i = king[0] - 1; i >= 0; i--) {
            int y = king[0] + king[1] - i;
            if (y >= 8) break;
            if (board[i][y]) {
                add2List(i, y, res);
                break;
            }
        }
        for (int i = king[0] + 1; i < 8; i++) {
            int y = king[0] + king[1] - i;
            if (y < 0) break;
            if (board[i][y]) {
                add2List(i, y, res);
                break;
            }
        }
        return res;
    }

    private void add2List(int x, int y, List<List<Integer>> res) {
        List<Integer> xy = new ArrayList<>();
        xy.add(x);
        xy.add(y);
        res.add(xy);
    }
}
