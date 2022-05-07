package leetcode._392;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl > tl) {
            return false;
        }
        if (sl == tl) {
            return s.equals(t);
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[][] dp = new int[sl + 1][tl + 1];
        for (int i = 0; i < sl; i++) {
            for (int j = 0; j < tl; j++) {
                if (dp[i + 1][j + 1] == sl) {
                    return true;
                }
                if (sChars[i] == tChars[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[sl][tl] == sl;
    }
}
