package leetcode._121;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int r = len - 1;
            while (r > i) {
                if (prices[r] > prices[i])
                    maxP = Math.max(maxP, prices[r] - prices[i]);
                r--;
            }
        }
        return maxP;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfitDP(int[] prices) {
        int length = prices.length;
        if (length == 0)
            return 0;
        // dp[i][0]表示到第i天持有股票的最大收益
        // dp[i][1]表示到第i天不持有股票的最大收益
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        return dp[length - 1][1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(b.maxProfitDP(prices));
    }
}
