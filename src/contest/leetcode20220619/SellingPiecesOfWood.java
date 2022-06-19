package contest.leetcode20220619;

public class SellingPiecesOfWood {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] A = new int[m + 1][n + 1];
        for (int[] price : prices) {
            A[price[0]][price[1]] = price[2];
        }
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = A[i][j];
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
            }
        }
        return dp[m][n];
    }
}
