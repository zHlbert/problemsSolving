package leetcode._1703;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/
 * 得到连续 K 个 1 的最少相邻交换次数
 */
public class MinimumAdjacentSwapsForKConsecutiveOnes {
    /**
     * 贪心 + 前缀和 + 滑动窗口
     * https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/solution/duo-tu-xin-shou-jiao-cheng-yi-bu-bu-dai-6bps4/
     * @param nums
     * @param k
     * @return
     */
    public int minMoves(int[] nums, int k) {
        List<Integer> zeros = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n && nums[i] == 0) {
            i++;
        }
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] == 0) j++;
            if (j < n) zeros.add(j - i - 1);
            i = j;
        }

        int m = zeros.size();
        int[] pSum = new int[m + 1];
        for (int j = 0; j < m; j++) {
            pSum[j + 1] = pSum[j] + zeros.get(j);
        }

        int cost = 0;
        int left = 0, right = k - 2;
        for (i = left; i <= right; i++)
            cost += zeros.get(i) * Math.min(i + 1, right - i + 1);

        int res = cost;
        i = 1;
        for (int j = i + k - 2; j < m; i++, j++) {
            int mid = (i + j) >> 1;
            cost -= pSum[mid] - pSum[i - 1];
            cost += pSum[j + 1] - pSum[mid + k & 1];
            res = Math.min(res, cost);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumAdjacentSwapsForKConsecutiveOnes ma = new MinimumAdjacentSwapsForKConsecutiveOnes();
//        int[] nums = new int[] {1,0,0,1,0,1};
//        int k = 2;
        int[] nums = new int[] {1,0,0,0,0,0,1,1};
        int k = 3;
        System.out.println(ma.minMoves(nums, k));
    }
}
