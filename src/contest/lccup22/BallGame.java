package contest.lccup22;

import utils.ArrayUtils;

import java.util.*;

public class BallGame {
    char[][] board;
    int mu = 1005;

    public int[][] ballGame(int num, String[] plate) {
        int m = plate.length;
        int n = plate[0].length();
        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] sc = plate[i].toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = sc[j];
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    queue.offer(new int[] {i * mu + j, -1});
                    visited.add(convert(i, j, -1));
                }
            }
        }
        if (queue.isEmpty()) {
            return new int[0][];
        }
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        Set<Integer> resSet = new HashSet<>();
        while (!queue.isEmpty() && num > 0) {
            int sz = queue.size();
            System.out.println(sz);
            for (int i = 0; i < sz; i++) {
                int[] pair = queue.poll();
                int pn = pair[0], dr = pair[1];
                int x = pn / mu, y = pn % mu;
//                System.out.println(Arrays.toString(new int[] {x, y, dr}));
                if (dr != -1 && entrance(m, n, x, y, d[dr][0], d[dr][1])) {
                    resSet.add(x * mu + y);
                }
                else if (onCorner(m, n, x, y)) {
//                    System.out.println(x + "," + y);
                    continue;
                }
                if (board[x][y] != 'E' && board[x][y] != 'W') {
                    if (board[x][y] == '.') {
                        int nx = x + d[dr][0], ny = y + d[dr][1];
                        if (valid(m, n, nx, ny) && !visited.contains(convert(nx, ny, dr))) {
                            queue.offer(new int[] {nx * mu + ny, dr});
                            visited.add(convert(nx, ny, dr));
                        }
                    } else {
                        for (int j = 0; j < 4; j++) {
                            int nx = x + d[j][0], ny = y + d[j][1];
                            if (valid(m, n, nx, ny) && !visited.contains(convert(nx, ny, j))) {
                                queue.offer(new int[] {nx * mu + ny, j});
                                visited.add(convert(nx, ny, j));
                            }
                        }
                    }
                } else {
                    int nd = (board[x][y] == 'E') ? (dr + 3) % 4 : (dr + 1) % 4;
                    int nx = x + d[nd][0], ny = y + d[nd][1];
                    if (valid(m, n, nx, ny) && !visited.contains(convert(nx, ny, nd))) {
//                        System.out.println(Arrays.toString(new int[] {x, y, nx, ny}));
                        queue.offer(new int[] {nx * mu + ny, nd});
                        visited.add(convert(nx, ny, nd));
                    }
                }
            }
            num--;
        }
        if (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] pair = queue.poll();
                int pn = pair[0], dr = pair[1];
                int x = pn / mu, y = pn % mu;
                if (entrance(m, n, x, y, d[dr][0], d[dr][1])) {
                    resSet.add(x * mu + y);
                }
            }
        }
        int l = resSet.size();
        int[][] res = new int[l][2];
        int i = 0;
        for (Integer pn : resSet) {
            int x = pn / mu, y = pn % mu;
            res[i][0] = x;
            res[i++][1] = y;
        }
        return res;
    }

    private boolean valid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private boolean onCorner(int m, int n, int x, int y) {
        boolean b = x == 0 && y == 0
                || x == 0 && y == n - 1
                || x == m - 1 && y == 0
                || x == m - 1 && y == n - 1;
        return board[x][y] == '.' && b;
    }

    private boolean entrance(int m, int n, int x, int y, int dx, int dy) {
        boolean b = (x == 0 && y > 0 && y < n - 1 && dy == 0)
                || (y == 0 && x > 0 && x < m - 1 && dx == 0)
                || (x == m - 1 && y > 0 && y < n - 1 && dy == 0)
                || (y == n - 1 && x > 0 && x < m - 1 && dx == 0);
        return b && board[x][y] == '.';
    }

    private int convert(int x, int y, int d) {
        return 10 * (x * mu + y) + d;
    }

    public static void main(String[] args) {
        BallGame bg = new BallGame();
//        String[] plate = {"..E.",".EOW","..W."};
//        int num = 4;
//        String[] plate = {".....","..E..",".WO..","....."};
//        int num = 5;
//        String[] plate = {".....","....O","....O",".....","....."};
//        int num = 3;
//        String[] plate = {".....","..O..","....."};
//        int num = 1;
//        String[] plate = {"....",".EE.","O.E.","...."};
//        int num = 6;
//        String[] plate = {"W.W.WE..",".WWWEW..","EWW.WE.E","E.W.E.E.",".OEOO.EO","WE.WOE.W","WW...E..",".WEWO..O","E....E..",".OWE...."};
//        int num = 69;
        String[] plate = {"E......O..","E.........","W..E...EW.","EE.OE.WWWO","O.WEOEWWW.",".OW..W....","W...EW.WE.",".E.W...OW.","OW...W.EEO","......W.W."};
        int num = 76;
        int[][] res = bg.ballGame(num, plate);
        System.out.println(res.length);
        ArrayUtils.print2DArray(res);
    }
}
