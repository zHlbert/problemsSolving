package leetcode._123;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        // 第一次持有，第一次释放
        int firstHold = Integer.MIN_VALUE, firstRelease = 0;
        // 第二次持有。第二次释放
        int secondHold = Integer.MIN_VALUE, secondRelease = 0;
        for (int price : prices) {
            // 第一次买
            firstHold = Math.max(firstHold, -price);
            // 第一次卖，再第一次持有基础上
            firstRelease = Math.max(firstRelease, firstHold + price);
            // 第二次买，在第一次释放基础上
            secondHold = Math.max(secondHold, firstRelease - price);
            // 第二次卖，在第二次持有基础上
            secondRelease = Math.max(secondRelease, secondHold + price);
        }
        return secondRelease;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
        int[] prices = new int[] {3,3,5,0,0,3,1,4};
        System.out.println(b.maxProfit(prices));
    }
}
