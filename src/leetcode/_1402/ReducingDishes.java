package leetcode._1402;

import java.util.Arrays;
import java.util.Comparator;

public class ReducingDishes {
    /**
     * 贪心
     * https://leetcode.cn/problems/reducing-dishes/submissions/476386668/?envType=daily-question&envId=2023-10-22
     * @param satisfaction
     * @return
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0, preSum = 0, n = satisfaction.length;
        for (int i = n - 1; i >= 0; i--) {
            if (preSum + satisfaction[i] > 0) {
                preSum += satisfaction[i];
                res += preSum;
            } else break;
        }
        return res;
    }
}
