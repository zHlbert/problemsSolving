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
    public String longestPalindromeExpand(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            int len1 = expandFromCenter(chars, i, i);
            int len2 = expandFromCenter(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(char[] chars, int l, int r) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring ls = new LongestPalindromicSubstring();
        System.out.println(ls.longestPalindromeExpand("babad"));
        System.out.println(ls.longestPalindromeExpand("babab"));
        System.out.println(ls.longestPalindromeExpand("a"));
        System.out.println(ls.longestPalindromeExpand("cbbd"));
        System.out.println(ls.longestPalindromeExpand("ac"));
        System.out.println(ls.longestPalindromeExpand("bb"));
    }
}
