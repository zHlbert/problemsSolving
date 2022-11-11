package leetcode._790;

public class DominoAndTrominoTiling {
    int mod = (int) (1e9 + 7);
    /**
     * 动态规划
     */
    public int numTilings(int n) {
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % mod + dp[i - 1][2]) % mod + dp[i - 1][3]) % mod;
        }
        return dp[n][3];
    }

    /**
     * 滚动数组
     * @param n
     * @return
     */
    public int numTilings1(int n) {
        long[] dp = new long[4];
        dp[3] = 1;
        for (int i = 1; i <= n; i++) {
            long[] ndp = new long[4];
            ndp[0b00] = dp[0b11];
            ndp[0b01] = (dp[0b00] + dp[0b10]) % mod;
            ndp[0b10] = (dp[0b00] + dp[0b01]) % mod;
            ndp[0b11] = (dp[0b00] + dp[0b01] + dp[0b10] + dp[0b11]) % mod;
            dp = ndp;
        }
        return (int) dp[0b11];
    }
}
