package contest.leetcode2022031302;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FinancialProduct {
    int mod = 1000000007;

    public int maxInvestment(int[] product, int limit) {
//        PriorityQueue<Integer> productQueue = new PriorityQueue<>(product.length, (o1, o2) -> o2 - o1);
        PriorityQueue<Integer> productQueue = new PriorityQueue<>(product.length, Comparator.reverseOrder());
        for (int p : product) {
            productQueue.offer(p);
        }

        int c = 0;
        int sum = 0;
        while (c < limit && !productQueue.isEmpty()) {
            c++;
            Integer peek = productQueue.poll();
            sum = sum % mod + peek;
            if (peek > 1) {
                productQueue.offer(peek - 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FinancialProduct f = new FinancialProduct();
        int[] product = new int[] {43877, 10848, 10442, 48132, 83395, 71523, 60275, 39527};
        int limit = 345056;
        System.out.println(f.maxInvestment(product, limit));
    }
}
