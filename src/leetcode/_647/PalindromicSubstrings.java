package leetcode._647;

public class PalindromicSubstrings {
    public int countSubstringsDoublePointers(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count += extend(chars, i, i, n);
            count += extend(chars, i, i + 1, n);
        }
        return count;
    }

    private int extend(char[] chars, int i, int j, int n) {
        int count = 0;
        while (i >= 0 && j < n && chars[i] == chars[j]) {
            count++;
            i--;
            j++;
        }
        return count;
    }

    public int countSubstringsDP(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (chars[i] == chars[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        String s = "aaa";
        System.out.println(ps.countSubstringsDP(s));
    }
}
