package leetcode._1475;

import utils.ArrayUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    /**
     * 单调栈
     * @param prices
     * @return
     */
    public int[] finalPrices1(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            while (!stack.isEmpty() && price <= prices[stack.peek()]) {
                int pre = stack.pop();
                prices[pre] -= price;
            }
            stack.push(i);
        }
        return prices;
    }

    /**
     * 单调栈 数组模拟栈
     * @param prices
     * @return
     */
    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            int price = prices[i];
            while (top > 0 && price <= prices[stack[top - 1]]) {
                prices[stack[--top]] -= price;
            }
            stack[top++] = i;
        }
        return prices;
    }

    public static void main(String[] args) {
        FinalPricesWithASpecialDiscountInAShop fp = new FinalPricesWithASpecialDiscountInAShop();
        int[] prices = new int[] {8,7,4,2,8,1,7,7,10,1};
        int[] res = fp.finalPrices2(prices);
        ArrayUtils.printArray(res);
    }
}
