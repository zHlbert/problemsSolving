package leetcode._213;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        return Math.max(rangeRob(nums, 0, len - 2), rangeRob(nums, 1, len - 1));
    }

    public int rangeRob(int[] nums, int begin, int end) {
        if (begin == end) {
            return nums[begin];
        }
        int[] dp = new int[end - begin + 1];
        dp[0] = nums[begin];
        dp[1] = Math.max(nums[begin], nums[begin + 1]);
        for (int i = 2; i <= end - begin; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + begin], dp[i - 1]);
        }
        return dp[end - begin];
    }
}
