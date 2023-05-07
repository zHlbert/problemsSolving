package leetcode._1263;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MinimumMovesToMoveABoxToTheirTargetLocation {
    /**
     * BFS
     * https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/solution/tui-xiang-zi-by-leetcode-solution-spzi/
     * @param grid
     * @return
     */
    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sx = -1, sy = -1, bx = -1, by = -1;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 'S') {
                    sx = x;
                    sy = y;
                } else if (grid[x][y] == 'B') {
                    bx = x;
                    by = y;
                }
            }
        }

        int[] d = {0, -1, 0, 1, 0};
        int[][] dp = new int[m * n][m * n];
        for (int i = 0; i < m * n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new ArrayDeque<>();
        dp[sx * n + sy][bx * n + by] = 0;
        q.offer(new int[] {sx * n + sy, bx * n + by});
        while (!q.isEmpty()) {
            Queue<int[]> q1 = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int[] arr = q.poll();
                int s1 = arr[0], b1 = arr[1];
                int s1x = s1 / n, s1y = s1 % n, b1x = b1 / n, b1y = b1 % n;
                if (grid[b1x][b1y] == 'T') return dp[s1][b1];
                for (int i = 0; i < 4; i++) {
                    int s2x = s1x + d[i], s2y = s1y + d[i + 1], s2 = s2x * n + s2y;
                    if (!inArea(grid, m, n, s2x, s2y)) {
                        continue;
                    }
                    if (b1x == s2x && b1y == s2y) {
                        int b2x = b1x + d[i], b2y = b1y + d[i + 1], b2 = b2x * n + b2y;
                        if (!inArea(grid, m, n, b2x, b2y) || dp[s2][b2] <= dp[s1][b1] + 1) continue;
                        dp[s2][b2] = dp[s1][b1] + 1;
                        q1.offer(new int[] {s2, b2});
                    } else {
                        if (dp[s2][b1] <= dp[s1][b1]) continue;
                        dp[s2][b1] = dp[s1][b1];
                        q.offer(new int[] {s2, b1});
                    }
                }
            }
            q = q1;
        }
        return -1;
    }

    private boolean inArea(char[][] grid, int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
    }
}
