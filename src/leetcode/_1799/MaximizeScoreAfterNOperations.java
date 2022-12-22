package leetcode._1799;

/**
 * N 次操作后的最大分数和
 * https://leetcode.cn/problems/maximize-score-after-n-operations/
 */
public class MaximizeScoreAfterNOperations {
    /**
     * 状态压缩 + 动态规划
     * @param nums
     * @return
     */
    public int maxScore(int[] nums) {
        int m = nums.length;
        int[][] gcds = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                gcds[i][j] = gcd(nums[i], nums[j]);
            }
        }

        int[] dp = new int[1 << m];
        int all = 1 << m;
        for (int s = 1; s < all; s++) {
            int t = Integer.bitCount(s);
            if ((t & 1) != 0) continue;
            for (int i = 0; i < m; i++)
                if (((s >> i) & 1) != 0)
                    for (int j = i + 1; j < m; j++)
                        if (((s >> j) & 1) != 0)
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + t / 2 * gcds[i][j]);
        }
        return dp[all - 1];
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
