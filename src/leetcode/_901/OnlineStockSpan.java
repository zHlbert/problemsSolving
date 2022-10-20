package leetcode._901;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        int[] prices = new int[] {100,80,60,70,60,75,85};
        for (int price : prices) {
            System.out.println(ss.next(price));
        }
    }

}

/**
 * 单调栈
 */
class StockSpanner {

    int c, N = 10010;

    // 数组模拟
    int[] stack;

    int top;

    int[] prices;

    public StockSpanner() {
        stack = new int[N];
        top = 0;
        prices = new int[N];
        c = 0;
    }

    public int next(int price) {
        int end = c;
        prices[c++] = price;
        while (top != 0 && price >= prices[stack[top - 1]]) {
            top--;
        }
        int start = top == 0 ? -1 : stack[top - 1];
        stack[top++] = end;
        return end - start;
    }
}
