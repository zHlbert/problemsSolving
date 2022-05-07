package leetcode._5;

/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArr = s.toCharArray();
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j = i + l - 1;
                if (j >= len) {
                    break;
                }
                if (charArr[i] != charArr[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && l > maxLen) {
                    maxLen = l;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // TODO: 中心扩展

    public static void main(String[] args) {
        LongestPalindromicSubstring ls = new LongestPalindromicSubstring();
        System.out.println(ls.longestPalindrome("babad"));
        System.out.println(ls.longestPalindrome("babab"));
        System.out.println(ls.longestPalindrome("a"));
        System.out.println(ls.longestPalindrome("cbbd"));
        System.out.println(ls.longestPalindrome("ac"));
    }
}
