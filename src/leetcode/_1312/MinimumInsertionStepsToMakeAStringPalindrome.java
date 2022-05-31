package leetcode._1312;

/**
 * https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    /**
     * 找到最长回文子序列长度x，则最小插入字符数 = 总长度n - x
     * @param s
     * @return
     */
    public int minInsertionsByDecr(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][n];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return n - dp[0][n - 1];
    }

    /**
     * 动态规划直接求出最少插入次数
     * @param s
     * @return
     */
    public int minInsertionsDirect(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        // dp[i][j] 表示 [s[i], s[j]] 之间最小插入次数
        int[][] dp = new int[n][n];
        char[] chars = s.toCharArray();

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    // 相等则无需插入
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // 不相等则找出 右界-1 或 左界+1 中最小插入次数 + 1
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        MinimumInsertionStepsToMakeAStringPalindrome mis = new MinimumInsertionStepsToMakeAStringPalindrome();
//        String s = "zzazz";
//        String s = "mbadm";
        String s = "leetcode";
        System.out.println(mis.minInsertionsDirect(s));
    }
}
