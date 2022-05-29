package contest.leetcode20220529;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.cn/contest/weekly-contest-295/problems/minimum-obstacle-removal-to-reach-corner/
 */
public class MinimumObstacleRemovalToReachCorner {
    int[][] dr = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    int minOb;
    int m, n;
    int[][] grid;
    public int minimumObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        minOb = m * n + 1;
        this.grid = grid;
        backtrack(0, 0, 0);
        return minOb;
    }

    private void backtrack(int row, int col, int ob) {
        if (ob > minOb) {
            return;
        }
        if (row == m - 1 && col == n - 1) {
            minOb = ob;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i][0];
            int nc = col + dr[i][1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                int oVal = grid[nr][nc];
                if (oVal != 2) {
                    grid[nr][nc] = 2;
                    backtrack(nr, nc, ob + oVal);
                    grid[nr][nc] = oVal;
                }
            }
        }
    }

    public int minimumObstaclesBFS(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dis = new int[m][n];
        for (int[] di : dis) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerFirst(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int x = cur[0], y = cur[1];
            for (int[] d : dr) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int g = grid[nx][ny];
                if (dis[x][y] + g < dis[nx][ny]) {
                    dis[nx][ny] = dis[x][y] + g;
                    if (g == 0) {
                        queue.offerFirst(new int[] {nx, ny});
                    } else {
                        queue.offerLast(new int[] {nx, ny});
                    }
                }
            }
        }
        return dis[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumObstacleRemovalToReachCorner mor = new MinimumObstacleRemovalToReachCorner();
//        int[][] grid = new int[][] {{0,1,1},{1,1,0},{1,1,0}};
        int[][] grid = new int[][] {{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}};
        System.out.println(mor.minimumObstaclesBFS(grid));
    }
}
