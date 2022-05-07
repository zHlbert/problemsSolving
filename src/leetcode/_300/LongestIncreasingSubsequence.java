package leetcode._300;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestIncreasingSubsequence {
    /**
     * 动态规划
     * dp[i] = max(dp[j]) + 1, 其中0 ≤ j < i且num[j] < num[i]
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    //  TODO: 贪心 + 二分查找

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        System.out.println(l.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(l.lengthOfLIS(new int[] {0,1,0,3,2,3}));
        System.out.println(l.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
        System.out.println(l.lengthOfLIS(new int[] {1,2,3,4,5}));
    }
}
