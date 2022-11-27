package leetcode._813;

/**
 * https://leetcode.cn/problems/largest-sum-of-averages/
 * 最大平均值和的分组
 */
public class LargestSumOfAverages {
    /**
     * https://leetcode.cn/problems/largest-sum-of-averages/solution/zui-da-ping-jun-zhi-he-de-fen-zu-by-leet-09xt/
     * @param nums
     * @param k
     * @return
     */
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        // 表示数组 nums 分成 k 个子数组后的最大平均值和
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = (double) prefix[i] / i;
        }

        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (double) (prefix[i] - prefix[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}
