package leetcode._1039;

public class MinimumScoreTriangulationOfPolygon {
    int n;
    int[] val;
    int[] memo;

    /**
     * 动态规划 记忆化搜索
     * @param values
     * @return
     */
    public int minScoreTriangulation(int[] values) {
        n = values.length;
        this.val = values;
        memo = new int[n * n + 1];
        return dp(0, n - 1);
    }

    private int dp(int i, int j) {
        if (i + 2 > j) return 0;
        if (i + 2 == j) return val[i] * val[i + 1] * val[j];
        int key = i * n + j;
        if (memo[key] == 0) {
            int score = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                score = Math.min(score, val[i] * val[k] * val[j] + dp(i, k) + dp(k, j));
            }
            memo[key] = score;
        }
        return memo[key];
    }
}
