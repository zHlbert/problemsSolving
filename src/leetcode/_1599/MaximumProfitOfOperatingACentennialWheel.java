package leetcode._1599;

public class MaximumProfitOfOperatingACentennialWheel {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int remains = 0, maxProfit = Integer.MIN_VALUE, minR = 0, profit = 0;
        int i = 0, n = customers.length;
        while (i < n || remains > 0) {
            int board;
            if (i < n) {
                board = Math.min(4, customers[i]);
                if (i == n - 1 && board < 4 && remains > 0) {
                    int plus = Math.min(remains, 4 - board);
                    board += plus;
                    remains -= plus;
                } else {
                    remains += Math.max(0, customers[i] - board);
                }
            } else {
                board = Math.min(4, remains);
                remains -= board;
            }
            i++;
            profit += boardingCost * board - runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                minR = i;
            }
        }
        return maxProfit > 0 ? minR : -1;
    }

    public static void main(String[] args) {
        MaximumProfitOfOperatingACentennialWheel mp = new MaximumProfitOfOperatingACentennialWheel();
        System.out.println(mp.minOperationsMaxProfit(new int[] {10,10,1,0,0}, 4, 4));
    }
}
