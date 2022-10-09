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


    /**
     * 贪心 + 二分查找
     * https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length, len = 1;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len;

                while (l < r) {
                    int mid = (l + r + 1) >> 1;
                    if (d[mid] < nums[i]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                int pos = d[l] < nums[i] ? l : 0;
                d[pos + 1] = nums[i];

            }
//            System.out.println(Arrays.toString(d));
        }
        return len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        System.out.println(l.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(l.lengthOfLIS(new int[] {0,1,0,3,2,3}));
        System.out.println(l.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
        System.out.println(l.lengthOfLIS(new int[] {1,2,3,4,5}));
    }
}
