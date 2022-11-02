package leetcode._1668;

public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        sequence = " " + sequence;
        word = " " + word;
        char[] s = sequence.toCharArray();
        char[] w = word.toCharArray();
        int[] ne = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && w[i] != w[j + 1]) j = ne[j];
            if (w[i] == w[j + 1]) j++;
            ne[i] = j;
        }

        int[] dp = new int[n + 1];
        int res = 0;
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != w[j + 1]) j = ne[j];
            if (s[i] == w[j + 1]) j++;
            if (j == m) {
                dp[i] = i < m ? 1 : dp[i - m] + 1;
                res = Math.max(res, dp[i]);
                j = ne[j];
            }
        }
        return res;
    }

    public int maxRepeating1(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n + 1];
        int res = 0;
        for (int i = m; i <= n; i++) {
            if (word.equals(sequence.substring(i - m, i))) {
                dp[i] = dp[i - m] + 1;
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
