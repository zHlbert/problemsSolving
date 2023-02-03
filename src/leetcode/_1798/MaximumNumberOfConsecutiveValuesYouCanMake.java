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
        int res = 1;
        for (int coin : coins) {
            if (coin > res)
                break;
            res += coin;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfConsecutiveValuesYouCanMake mn = new MaximumNumberOfConsecutiveValuesYouCanMake();
        System.out.println(mn.getMaximumConsecutive(new int[]{1, 3}));
        System.out.println(mn.getMaximumConsecutive(new int[]{1, 1, 1, 4}));
    }
}
