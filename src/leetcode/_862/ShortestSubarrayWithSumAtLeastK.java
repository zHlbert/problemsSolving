package leetcode._862;

public class ShortestSubarrayWithSumAtLeastK {
    /**
     * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/solution/he-zhi-shao-wei-k-de-zui-duan-zi-shu-zu-57ffq/
     *
     * 前缀和 + 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] q = new int[n + 1];
        int head = 0, tail = -1;
        int res = n + 1;
        for (int i = 0; i <= n; i++) {
            long curSum = preSum[i];
            while (head <= tail && curSum - preSum[q[head]] >= k) {
                res = Math.min(res, i - q[head++]);
            }
            while (head <= tail && preSum[q[tail]] >= curSum) {
                tail--;
            }
            q[++tail] = i;
        }
        return res < n + 1 ? res : -1;
    }
}
