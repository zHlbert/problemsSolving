package leetcode._72;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int w1l = word1.length();
        int w2l = word2.length();
        int[][] dp = new int[w1l + 1][w2l + 1];
        for (int i = 1; i <= w1l; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= w2l; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= w1l; i++) {
            for (int j = 1; j <= w2l; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[w1l - 1][w2l - 1];
    }
}
