package contest.leetcode20220625;

/**
 * https://leetcode.cn/problems/number-of-distinct-roll-sequences/
 */
public class NumberOfDistinctRollSequences {
    int mod = (int) (1e9 + 7);

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public int distinctSequences(int n) {
        if (n == 1) {
            return 6;
        }

        // dp[i][j][k] 表示 扔第i次时，上上次点数为j，上次点数为k的序列数目
        int[][][] dp = new int[n + 1][6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (gcd(i + 1, j + 1) == 1 && i != j) {
                    dp[2][i][j] = 1;
                }
            }
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j != k && gcd(j + 1, k + 1) == 1) {
                        for (int u = 0; u < 6; u++) {
                            if (u != j && u != k && gcd(u + 1, j + 1) == 1) {
                                dp[i][j][k] = (dp[i][j][k] + dp[i - 1][u][j]) % mod;
                            }
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                res = (res + dp[n][i][j]) % mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfDistinctRollSequences nc = new NumberOfDistinctRollSequences();
        System.out.println(nc.distinctSequences(2));
        System.out.println(nc.distinctSequences(3));
        System.out.println(nc.distinctSequences(4));
        System.out.println(nc.distinctSequences(5));
//        System.out.println(nc.mod);
    }
}
