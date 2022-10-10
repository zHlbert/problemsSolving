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
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i], b1 = nums2[i - 1], b2 = nums2[i];
            if ((a1 < a2 && b1 < b2)) {
                if (a1 < b2 && b1 < a2) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] = dp[i][0] + 1;
                } else {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    // TODO: 2022/10/10 滑动数组
}
