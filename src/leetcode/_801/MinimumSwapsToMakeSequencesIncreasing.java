package leetcode._801;

/**
 * https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    /**
     * DP 动态规划 状态机
     * @param nums1
     * @param nums2
     * @return
     */
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        // dp[i][0] 表示 到第i步不交换所用的最小交换次数
        // dp[i][1] 表示 到第i步交换所用的最小交换次数
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            if ((a1 < a2 && b1 < b2)) {
                if (a1 < b2 && b1 < a2) {
                    // 交换后递增也成立
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]); // 第i步不交换, 第 i - 1 步可交换也可不交换
                    dp[i][1] = dp[i][0] + 1; // 第i步交换, 第 i - 1 步可交换也可不交换
                } else {
                    dp[i][0] = dp[i - 1][0]; // 第i步不交换, 则 第 i - 1 步也不能交换
                    dp[i][1] = dp[i - 1][1] + 1; // // 第i步交换, 则 第 i - 1 步也需要交换
                }
            } else {
                dp[i][0] = dp[i - 1][1]; // 第i步不交换, 则 第 i - 1 步需要交换
                dp[i][1] = dp[i - 1][0] + 1; // // 第i步交换, 则 第 i - 1 步不能交换edererrr
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    // 2022/10/10 滚动数组
    public int minSwap1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int x = 0, y = 1;
        for (int i = 1; i < n; i++) {
            int x0 = x, y0 = y;
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            if (a1 < a2 && b1 < b2) {
                if (a1 < b2 && b1 < a2) {
                    x = Math.max(x0, y0);
                    y = x + 1;
                } else {
                    x = x0;
                    y = y0 + 1;
                }
            } else {
                x = y0;
                y = x0 + 1;
            }
        }
        return Math.min(x, y);
    }
}
