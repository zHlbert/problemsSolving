package contest.leetcode20220710;

/**
 * https://leetcode.cn/problems/count-the-number-of-ideal-arrays/
 */
public class CountTheNumberOfIdealArrays {
    static int mod = (int) (1e9 + 7);
    public int idealArrays(int n, int m) {

        // 2 ^ 13 < 10000 < 2 ^ 14 理想数组里最多有13个不同的（满足前一个数是后一个数的因子的）数
        // dp[i][j] 表示 以 i 结尾的长度为 j 的 数组数目
        int[][] dp = new int[m + 1][15];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }

        for (int j = 1; j < 14; j++) {
            for (int i = 1; i <= m; i++) {
                for (int k = 2; k * i <= m; k++) {
                    dp[k * i][j + 1] = (dp[k * i][j + 1] + dp[i][j]) % mod;
                }
            }
        }

        // 计算组合数
        int[][] C = new int[n][15];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i && j <= 14; j++) {
                if (j == 0)
                    C[i][j] = 1;
                else
                    C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % mod;
            }
        }

        long res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 14 && j <= n; j++) {
                // 最大数为 i, 有 j 个在 [1, min(14, n)] 的数 的数组数 = sum(dp[i][j] * C(n - 1, j - 1))
                // 数组长度为 n, 有 j 个 数，不同方案数 用插板法 : n - 1 个空中插 j - 1 个板
                res = (res + (long) dp[i][j] * C[n - 1][j - 1]) % mod;
            }
        }
        return (int) res;
    }
}
