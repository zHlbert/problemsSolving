package leetcode._983;

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
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 同 interview_experience.MinimumCostForTravel
 */
public class MinimumCostForTickets {
    int[] days, costs;
    Integer[] memo;
    int[] durations = new int[] {1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        return dp(0);
    }

    private int dp(int i) {
        if (i >= days.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        memo[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; k++) {
            while (j < days.length && days[j] < days[i] + durations[k]) {
                j ++;
            }
            memo[i] = Math.min(memo[i], costs[k] + dp(j));
        }
        return memo[i];
    }

    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        int[] days = new int[] {1,4,6,7,8,20};
        int[] costs = new int[] {2,7,15};
        System.out.println(m.mincostTickets(days, costs));
    }
}
