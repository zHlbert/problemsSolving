package leetcode._1330;

public class ReverseSubArratToMaximizeArrayValue {
    /**
     * https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/solution/c-fen-lei-tao-lun-by-muriyatensei-rubr/
     * 贪心
     * @param nums
     * @return
     */
    public int maxValueAfterReverse(int[] nums) {
        int sum = 0, lowMax = Integer.MIN_VALUE, highMin = Integer.MAX_VALUE, ot = 0;
        for (int i = 1, n = nums.length; i < n; i++) {
            int x = nums[i - 1], y = nums[i], d = Math.abs(x - y);
            lowMax = Math.max(lowMax, Math.min(x, y));
            highMin = Math.min(highMin, Math.max(x, y));
            sum += d;
            ot = Math.max(ot, Math.max(Math.abs(nums[0] - y) - d, Math.abs(x - nums[n - 1]) - d));
        }
        return Math.max(ot, (lowMax - highMin) * 2) + sum;
    }
}
