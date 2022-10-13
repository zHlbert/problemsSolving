package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/distinct-subsequences-ii/
 */
public class DistinctSubsequencesII {
    static int mod = (int) (1e9 + 7);

    /**
     * https://leetcode.cn/problems/distinct-subsequences-ii/solution/bu-tong-de-zi-xu-lie-ii-by-leetcode-solu-k2h5/
     *
     * DP
     * @param s
     * @return
     */
    public int distinctSubseqII(String s) {
        char[] sc = s.toCharArray();
        int[] dp = new int[26];
        for (char c : sc) {
            int sum = 1;
            for (int i = 0; i < 26; i++) {
                sum = (sum + dp[i]) % mod;
            }
            dp[c - 'a'] = sum;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = (res + dp[i]) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        DistinctSubsequencesII ds = new DistinctSubsequencesII();
        System.out.println(ds.distinctSubseqII("abc"));
        System.out.println(ds.distinctSubseqII("adbae"));
    }
}
