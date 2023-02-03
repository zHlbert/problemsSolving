package leetcode._1798;

import java.util.Arrays;

public class MaximumNumberOfConsecutiveValuesYouCanMake {
    /**
     * 排序 贪心
     * @param coins
     * @return
     */
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 0;
        for (int coin : coins) {
            if (coin > res + 1)
                return res + 1;
            res += coin;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        MaximumNumberOfConsecutiveValuesYouCanMake mn = new MaximumNumberOfConsecutiveValuesYouCanMake();
        System.out.println(mn.getMaximumConsecutive(new int[]{1, 3}));
        System.out.println(mn.getMaximumConsecutive(new int[]{1, 1, 1, 4}));
    }
}
