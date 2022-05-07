package leetcode._115;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int[][] dp = new int[sl + 1][tl + 1];
        for (int i = 0; i <= sl; i++) {
            dp[i][0] = 1;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= tl; j++) {
                if (sChars[i - 1] == tChars[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sl][tl];
    }
}
