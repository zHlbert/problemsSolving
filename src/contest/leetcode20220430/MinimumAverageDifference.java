package contest.leetcode20220430;

/**
 * You are given a 0-indexed integer array nums of length n.
 *
 * The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.
 *
 * Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
 *
 * Note:
 *
 * The absolute difference of two numbers is the absolute value of their difference.
 * The average of n elements is the sum of the n elements divided (integer division) by n.
 * The average of 0 elements is considered to be 0.
 *
 */
public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long minAvgDiff = Integer.MAX_VALUE;
        int n = nums.length;
        long tmp = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            tmp += nums[i];
            long left = tmp / (i + 1);
            long right = ((i == n - 1) ? 0 : (sum - tmp) / (n - i - 1));
            long abs = Math.abs(left - right);
            if (abs < minAvgDiff) {
                minAvgDiff = abs;
                index = i;
            }
//            System.out.println(i + ", " + left + ", " + right + ", " + minAvgDiff);
        }
        return index;
    }

    public static void main(String[] args) {
        MinimumAverageDifference mad = new MinimumAverageDifference();
        int[] nums = new int[] {1};
        System.out.println(mad.minimumAverageDifference(nums));
    }
}
