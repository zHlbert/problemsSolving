package leetcode._1760;

import java.util.PriorityQueue;

/**
 * 袋子里最少数目的球
 * https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/
 */
public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int r = 0;
        for (int num : nums)
            r = Math.max(r, num);
        int l = 1;
        // 二分
        while (l < r) {
            int mid = (l + r) >> 1;
            // 拆分次数
            int cnt = 0;
            for (int num : nums)
                if (num > mid)
                    cnt += (num - 1) / mid;

            // 拆分次数 与袋子中最多球数 反比
            if (cnt <= maxOperations) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
