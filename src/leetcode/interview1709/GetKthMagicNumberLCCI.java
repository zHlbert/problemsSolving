package leetcode.interview1709;

import java.util.Arrays;

public class GetKthMagicNumberLCCI {
    /**
     * 动态规划 DP
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int c3 = 1, c5 = 1, c7 = 1;
        for (int i = 2; i <= k; i++) {
            int n3 = dp[c3] * 3, n5 = dp[c5] * 5, n7 = dp[c7] * 7;
            int cur = Math.min(n3, Math.min(n5, n7));
            if (cur == n3) {
                c3++;
            }
            if (cur == n5) {
                c5++;
            }
            if (cur == n7) {
                c7++;
            }
            dp[i] = cur;
        }
        return dp[k];
    }

    public static void main(String[] args) {
        GetKthMagicNumberLCCI gk = new GetKthMagicNumberLCCI();
        System.out.println(gk.getKthMagicNumber(15));
    }
}
