package contest.leetcode20220514;

/**
 * https://leetcode.cn/contest/biweekly-contest-78/problems/number-of-ways-to-split-array/
 */
public class NumberOfWaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long preSum = 0;
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            preSum += nums[i];
            if (preSum + preSum >= sum) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfWaysToSplitArray nwsa = new NumberOfWaysToSplitArray();
//        int[] nums = new int[] {10,4,-8,7};
        int[] nums = new int[] {2,3,1,0};
        System.out.println(nwsa.waysToSplitArray(nums));
    }
}
