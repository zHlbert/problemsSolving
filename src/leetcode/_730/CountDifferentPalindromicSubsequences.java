package leetcode._730;

/**
 * https://leetcode.cn/problems/count-different-palindromic-subsequences/
 */
public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[][][] dp = new int[4][n][n];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[chars[i] - 'a'][i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0, j = len - 1; j < n; i++, j++) {
                for (char c = 'a', k = 0; c <= 'd'; c++, k++) {
                    if (chars[i] == c && chars[j] == c) {
                        dp[k][i][j] = (2
                                + (dp[0][i + 1][j - 1] + dp[1][i + 1][j - 1]) % mod
                                + (dp[2][i + 1][j - 1] + dp[3][i + 1][j - 1]) % mod) % mod;
                    } else if (chars[i] == c) {
                        dp[k][i][j] = dp[k][i][j - 1];
                    } else if (chars[j] == c) {
                        dp[k][i][j] = dp[k][i + 1][j];
                    } else {
                        dp[k][i][j] = dp[k][i + 1][j - 1];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = (res + dp[i][0][n - 1]) % mod;
        }
        return res;
    }
}
