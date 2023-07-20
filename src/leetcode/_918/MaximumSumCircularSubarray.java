package leetcode._918;

public class MaximumSumCircularSubarray {
    /**
     * https://leetcode.cn/problems/maximum-sum-circular-subarray/solution/huan-xing-zi-shu-zu-de-zui-da-he-by-leet-elou/
     * 动态规划
     *
     * 最大子数组和中元素有两种情况 nums[i, ... , j]
     * 1. nums[i, ..., j], 其中 0 <= i <= j <= n - 1; 此时计算最大子数组和 resMax
     * 2. nums[j, ..., n - 1], nums[0, ..., i], 分为两段，这时可计算[i + 1 , j - 1]区间的最小和 resMin，取 max(resMax, sum - resMin)
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int preMin = nums[0], minRes = nums[0];
        int preMax = nums[0], maxRes = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            preMin = Math.min(preMin + x, x);
            minRes = Math.min(minRes, preMin);
            preMax = Math.max(preMax + x, x);
            maxRes = Math.max(maxRes, preMax);
            sum += x;
        }
        // 如果最大子数组和小于0，说明所有元素均小于0，最小子数组包含所有元素，由于子数组至少有一个元素，所以只能取最大子数组和
        if (maxRes < 0) return maxRes;
        else return Math.max(maxRes, sum - minRes);
    }
}
