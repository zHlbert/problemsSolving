package leetcode._746;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 2], dp[len - 1]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int len = cost.length;
        int dp0 = cost[0];
        int dp1 = cost[1];
        for (int i = 2; i < len; i++) {
            int dpi = Math.min(dp0, dp1) + cost[i];
            dp0 = dp1;
            dp1 = dpi;
        }
        return Math.min(dp0, dp1);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        int[] costs = new int[] {1,100,1,1,1,100,1,1,100,1};
        System.out.println(m.minCostClimbingStairs2(costs));
    }
}

