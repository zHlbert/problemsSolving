package leetcode._2517;

import java.util.Arrays;

public class MaximumTastinessOfCandyBasket {
    /**
     * 二分
     * @param price
     * @param k
     * @return
     */
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(price, k, mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private boolean check(int[] price, int k, int tastiness) {
        int pre = Integer.MIN_VALUE >> 1;
        int cnt = 0;
        for (int p : price) {
            if (p - pre >= tastiness) {
                cnt++;
                pre = p;
            }
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        MaximumTastinessOfCandyBasket mt = new MaximumTastinessOfCandyBasket();
        System.out.println(mt.maximumTastiness(new int[] {13,5,1,8,21,2}, 3));
    }
}
