package leetcode._1223;

public class DiceRollSimulation {
    int mod = (int) (1e9 + 7);
//    public int dieSimulator(int n, int[] rollMax) {
//        long[][] dp = new long[n + 1][6];
//        for (int i = 0; i < 6; i++) {
//            dp[1][i] = 1;
//        }
//
//        for (int i = 2; i <= n; i++) {
//            for (int j = 0; j < 6; j++) {
//                for (int k = 0; k < 6; k++) {
////                    if (j != k) {
////                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
////                    } else {
////                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
////                        int pre = Math.max(0, i - rollMax[j]);
////                        dp[i][j] = (dp[i][j] - dp[pre][j]) % mod;
////                    }
//                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
//                    if (j == k) {
//                        int pre = Math.max(0, i - rollMax[j]);
//                        dp[i][j] = (dp[i][j] - dp[pre][j]) % mod;
//                    }
//                }
//                System.out.println(i + ", " + j + ": " + dp[i][j]);
//            }
//        }
//
//        long res = 0;
//        for (int i = 0; i < 6; i++) {
//            res = (res + dp[n][i]) % mod;
//        }
//        return (int) res;
//    }

    /**
     * 动态规划
     * https://leetcode.cn/problems/dice-roll-simulation/solution/zhi-tou-zi-mo-ni-by-leetcode-solution-yg0s/
     *
     * @param n
     * @param rollMax
     * @return
     */
    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n + 1][6];
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                int pos = Math.max(0, i - rollMax[j] - 1);
                int sub = ((sum[pos] - dp[pos][j]) % mod + mod) % mod;
                dp[i][j] = ((sum[i - 1] - sub) % mod + mod) % mod;
                if (i <= rollMax[j])
                    dp[i][j] = (dp[i][j] + 1) % mod;
                sum[i] = (sum[i] + dp[i][j]) % mod;
            }
        }
        return sum[n];
    }

    public static void main(String[] args) {
        DiceRollSimulation dr = new DiceRollSimulation();
//        int n = 2;
//        int[] rollMax = new int[] {1,1,2,2,2,3};
//        int n = 2;
//        int[] rollMax = new int[] {1,1,1,1,1,1};
//        int n = 3;
//        int[] rollMax = new int[] {1,1,1,2,2,3};
        int n = 4;
        int[] rollMax = new int[] {2,1,1,3,3,2};
        System.out.println(dr.dieSimulator(n, rollMax));
    }
}
