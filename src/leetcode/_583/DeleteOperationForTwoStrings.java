package leetcode._583;

/**
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int w1l = w1.length;
        int w2l = w2.length;
        int[][] dp = new int[w1l + 1][w2l + 1];
        for (int i = 0; i <= w1l; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2l; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= w1l; i++) {
            for (int j = 1; j <= w2l; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[w1l][w2l];
    }
}
