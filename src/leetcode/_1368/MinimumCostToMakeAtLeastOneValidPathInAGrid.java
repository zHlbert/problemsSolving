package leetcode._1368;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 */
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {
    int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    // 0-1 BFS
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dis = new int[m][n];
        for (int[] di : dis) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[] {0,0});
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0], y = cur[1];
            int curD = grid[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int cost = (curD == i + 1) ? 0 : 1;
                if (dis[x][y] + cost < dis[nx][ny]) {
                    dis[nx][ny] = dis[x][y] + cost;
                    // 保证队列中距离是单调递增的
                    int[] nv = {nx, ny};
                    if (cost == 0) {
                        deque.offerFirst(nv);
                    } else {
                        deque.offerLast(nv);
                    }
                }
            }
        }
        return dis[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumCostToMakeAtLeastOneValidPathInAGrid mc = new MinimumCostToMakeAtLeastOneValidPathInAGrid();
//        int[][] grid = new int[][] {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
//        int[][] grid = new int[][] {{1,1,3},{3,2,2},{1,1,4}};
        int[][] grid = new int[][] {{1,2},{4,3}};
        System.out.println(mc.minCost(grid));
    }
}
