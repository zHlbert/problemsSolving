package leetcode._1801;

import java.util.*;

public class NumberOfOrdersInTheBacklog {
    int mod = (int) (1e9 + 7);

    /**
     * 优先队列
     * @param orders
     * @return
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sells = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> buys = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (!sells.isEmpty() && sells.peek()[0] <= order[0] && order[1] > 0) {
                    int[] peek = sells.peek();
                    if (peek[1] >= order[1]) {
                        peek[1] -= order[1];
                        order[1] = 0;
                        if (peek[1] == 0) sells.poll();
                        break;
                    } else {
                        sells.poll();
                        order[1] -= peek[1];
                    }
                }
                if (order[1] > 0) buys.offer(order);
            } else {
                while (!buys.isEmpty() && buys.peek()[0] >= order[0] && order[1] > 0) {
                    int[] peek = buys.peek();
                    if (peek[1] >= order[1]) {
                        peek[1] -= order[1];
                        order[1] = 0;
                        if (peek[1] == 0) buys.poll();
                        break;
                    } else {
                        buys.poll();
                        order[1] -= peek[1];
                    }
                }
                if (order[1] > 0) sells.offer(order);
            }
        }

        long res = 0;
        while (!buys.isEmpty())
            res = (res + buys.poll()[1]) % mod;
        while (!sells.isEmpty())
            res = (res + sells.poll()[1]) % mod;
        return (int) res;
    }

    public static void main(String[] args) {
        NumberOfOrdersInTheBacklog no = new NumberOfOrdersInTheBacklog();
        int[][] orders = new int[][] {{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}};
        System.out.println(no.getNumberOfBacklogOrders(orders));
    }
}
