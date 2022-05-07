package leetcode._188;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int[] hold = new int[k + 1];
        int[] release = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            hold[i] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                hold[i] = Math.max(hold[i], release[i - 1] - price);
                release[i] = Math.max(release[i], hold[i] + price);
            }
        }
        return release[k];
    }
}
