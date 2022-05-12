package leetcode.interview0105;

import utils.ArrayUtils;

/**
 *
 */
public class OneAwayLCCI {
    public boolean oneEditAwayDP(String first, String second) {
        int m = first.length(), n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int[][] dp = new int[m + 1][n + 1];
        char[] s1 = first.toCharArray(), s2 = second.toCharArray();
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                if (dp[i - 1][j - 1] > 1 && dp[i][j - 1] > 1 && dp[i - 1][j] > 1) {
//                    return false;
//                }
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else  {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        ArrayUtils.print2DArray(dp);
        return dp[m][n] <= 1;
    }

    public boolean oneEditAway2Pointers(String first, String second) {
        int m = first.length(), n = second.length();
        int diff = m - n;
        if (Math.abs(diff) > 1) {
            return false;
        }
        char[] s1 = first.toCharArray(), s2 = second.toCharArray();
        int count = 1;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            if (s1[i] != s2[j]) {
                if (diff == 1) {
                    // first比较长，考虑second增加一个字符
                    j--;
                } else if (diff == -1) {
                    // second比较长，考虑first增加一个字符串
                    i--;
                }
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneAwayLCCI oa = new OneAwayLCCI();
        String first = "islander";
        String second = "islander";
        System.out.println(oa.oneEditAway2Pointers(first, second));
    }
}
