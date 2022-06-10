package leetcode._926;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 */
public class FlipStringToMonotoneIncreasing {
//    public int minFlipsMonoIncr(String s) {
//        char[] chars = s.toCharArray();
//        int n = chars.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        int maxL = 1;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (chars[i] >= chars[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            if (dp[i] > maxL) {
//                maxL = dp[i];
//            }
//        }
//        return n - maxL;
//    }

    public int minFlipsMonoIncrDP(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        // dp[i][0] 表示 s[i] == 0 且 [0, i]为递增的最小翻转次数
        // dp[i][1] 表示 s[i] == 1 且 [0, i]为递增的最小翻转次数
        int[][] dp = new int[n][2];
        dp[0][0] = chars[0] == '0' ? 0 : 1;
        dp[0][1] = chars[0] == '1' ? 0 : 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (chars[i] == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (chars[i] == '1' ? 0 : 1);
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public int minFlipsMonoIncrDPCompress(String s) {
        char[] chars = s.toCharArray();
        // dp0 表示 s[i] == 0 且 [0, i]为递增的最小翻转次数
        // dp1 表示 s[i] == 1 且 [0, i]为递增的最小翻转次数
        int dp0 = 0, dp1 = 0;
        for (char c : chars) {
            // 由于 dp1 用到 dp0 所以先更新 dp1
            dp1 = Math.min(dp0, dp1) + ('1' - c);
            dp0 += c - '0';
        }
        return Math.min(dp0, dp1);
    }

    public int minFlipsMonoIncrDP1(String s) {
        char[] chars = s.toCharArray();
        int oneCnt = 0;
        // 最小翻转次数
        int dp = 0;
        for (char c : chars) {
            if (c == '1') {
                // 为 1 时无需翻转
                // 记录 1 的个数
                oneCnt++;
            } else {
                // 为 0 时 要么 0 翻转为 1，要么前面所有 1 翻转为 0
                dp = Math.min(dp + 1, oneCnt);
            }
        }
        return dp;
    }
}
