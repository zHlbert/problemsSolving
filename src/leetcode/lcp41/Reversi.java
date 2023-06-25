package leetcode.lcp41;

import java.util.ArrayDeque;
import java.util.Queue;

public class Reversi {
    static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};
//    char[][] cb;
    int m, n;
    public int flipCheese(String[] chessboard) {
        m = chessboard.length;
        n = chessboard[0].length();
        char[][] cb = new char[m][n];
        for (int i = 0; i < m; i++) {
            cb[i] = chessboard[i].toCharArray();
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cb[i][j] == '.') {
                    res = Math.max(res, bfs(cb, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(char[][] cb0, int px, int py) {
        char[][] cb = new char[m][n];
        for (int i = 0; i < m; i++) {
            if (n >= 0) System.arraycopy(cb0[i], 0, cb[i], 0, n);
        }
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {px, py});
        cb[px][py] = 'X';
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 8; i++) {
                if (judge(cb, p[0], p[1], dx[i], dy[i])) {
                    int x = p[0] + dx[i], y = p[1] + dy[i];
                    for ( ;cb[x][y] != 'X'; x += dx[i], y += dy[i]) {
                        q.offer(new int[] {x, y});
                        cb[x][y] = 'X';
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private boolean judge(char[][] cb, int x, int y, int dx, int dy) {
        x += dx;
        y += dy;
        for (; inBorder(x, y); x += dx, y += dy) {
            if (cb[x][y] == 'X') return true;
            if (cb[x][y] == '.') return false;
        }
        return false;
    }

//    private int flip(int x, int y) {
//        int sum = 0;
//        for (int i = 0; i < 8; i++) {
//            int dSum = 0;
//            int dxx = dx[i], dyy = dy[i];
//            int nx = x + dxx, ny = y + dyy;
//            for (; inBorder(nx, ny); nx += dxx, ny += dyy) {
//                if (cb[nx][ny] == '.') {
//                    dSum = 0;
//                    break;
//                }
//                if (cb[nx][ny] == 'X') break;
//                dSum++;
//            }
//            if (inBorder(nx, ny) && cb[nx][ny] == 'X') sum += dSum;
//        }
//        return sum;
//    }

    private boolean inBorder(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        Reversi rv = new Reversi();
        String[] chessBoard = {"....X.", "....X.", "XOOO..", "......", "......"};
//        String[] chessBoard = {".X.", ".O.", "XO."};

        System.out.println(rv.flipCheese(chessBoard));
    }
}
