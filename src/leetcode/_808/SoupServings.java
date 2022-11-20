package leetcode._808;

/**
 * 分汤
 * https://leetcode.cn/problems/soup-servings/
 */
public class SoupServings {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public double soupServings(int n) {
        n = (n + 24) / 25;
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j]
                        + dp[Math.max(0, i - 3)][Math.max(0, j - 1)]
                        + dp[Math.max(0, i - 2)][Math.max(0, j - 2)]
                        + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4;
            }
        }
        return dp[n][n];
    }
}
