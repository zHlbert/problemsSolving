package leetcode._741;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/cherry-pickup/
 */
public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        // 转化为两人a, b同时出发，每次走一格，方向都为向右或向下
        // 两人坐标 (x1, y1) (x2, y2) 满足 x1 + y1 = x2 + y2 = k
        // dp[k][x1][x2] 表示 横纵坐标和为k，a
        int[][][] dp = new int[n * 2 - 1][n][n];
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int k = 1; k < 2 * n - 1; k++) {
            for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); x1++) {
                int y1 = k - x1;
                if (grid[x1][y1] == -1) {
                    continue;
                }
                for (int x2 = x1; x2 <= Math.min(k, n - 1); x2++) {
                    int y2 = k - x2;
                    if (grid[x2][y2] == -1) {
                        continue;
                    }

                    // 计算 a , b 分别从左或上 移动过来的最大值
                    int res = dp[k - 1][x1][x2];
                    if (x1 > 0) {
                        res = Math.max(res, dp[k - 1][x1 - 1][x2]);
                    }
                    if (x2 > 0) {
                        res = Math.max(res, dp[k - 1][x1][x2 - 1]);
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, dp[k - 1][x1 - 1][x2 - 1]);
                    }
                    res += grid[x1][y1];
                    // 如果不在同一点，则加上b
                    if (x2 != x1) {
                        res += grid[x2][y2];
                    }
                    dp[k][x1][x2] = res;
                }
            }
        }
        return Math.max(dp[2 * n - 2][n - 1][n - 1], 0);
    }
}
