package interview_experience;

import leetcode._983.MinimumCostForTickets;
import utils.ArrayUtils;

import java.util.Arrays;

/**
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in three different ways:
 *
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 同 https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/
 */
public class MinimumCostForTravel {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int last = days[n - 1];
        // dp[i] 表示当天最小花费
        int[] dp = new int[last + 1];
        int index = 0;
        for (int i = 1; i <= last; i++) {
            if (i == days[index]) {
                int idx1 = Math.max(i - 1, 0);
                int idx7 = Math.max(i - 7, 0);
                int idx30 = Math.max(i - 30, 0);
                int minCost = Math.min(dp[idx1] + costs[0], dp[idx7] + costs[1]);
                minCost = Math.min(minCost, dp[idx30] + costs[2]);
                dp[i] = minCost;
                index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        ArrayUtils.printArray(dp);
        return dp[last];
    }

    // dp 数组长度根据days数组长度
    public int mincostTicketsDaysDP(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
//        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + costs[0];
            // 前一个7/30天内的days
            int pre = i - 1;
            while (pre > 0 && days[i - 1] - days[pre - 1] + 1 <= 7) {
                pre--;
            }
            dp[i] = Math.min(dp[i], dp[pre] + costs[1]);
            while (pre > 0 && days[i - 1] - days[pre - 1] + 1 <= 30) {
                pre--;
            }
            dp[i] = Math.min(dp[i], dp[pre] + costs[2]);
        }
        ArrayUtils.printArray(dp);
        return dp[n];
    }

    public static void main(String[] args) {
        MinimumCostForTravel mct = new MinimumCostForTravel();
        int[] days = new int[] {1,3,7};
        int[] costs = new int[] {1,4,20};
        System.out.println(mct.mincostTicketsDaysDP(days, costs));
    }
}
