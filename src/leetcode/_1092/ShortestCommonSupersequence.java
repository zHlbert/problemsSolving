package leetcode._1092;

public class ShortestCommonSupersequence {
    /**
     * 动态规划
     * https://leetcode.cn/problems/shortest-common-supersequence/solution/zui-duan-gong-gong-chao-xu-lie-by-leetco-c1tu/
     *
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] c1 = str1.toCharArray(), c2 = str2.toCharArray();
        // dp[i][j] 表示 字符串 str1[i:n] 和 str2[j:m]作为子序列的最短字符串长度
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][m] = n - i;
        }
        for (int i = 0; i < m; i++) {
            dp[n][i] = m - i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (c1[i] == c2[j]) dp[i][j] = dp[i + 1][j + 1] + 1;
                else dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int t1 = 0, t2 = 0;
        while (t1 < n && t2 < m) {
            if (c1[t1] == c2[t2]) {
                sb.append(c1[t1]);
                t1++;
                t2++;
            } else if (dp[t1 + 1][t2] == dp[t1][t2] - 1) {
                sb.append(c1[t1]);
                t1++;
            } else if (dp[t1][t2 + 1] == dp[t1][t2] - 1) {
                sb.append(c2[t2]);
                t2++;
            }
        }
        if (t1 < n) sb.append(str1.substring(t1));
        if (t2 < m) sb.append(str2.substring(t2));
        return sb.toString();
    }
}
