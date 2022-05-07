package leetcode._713;

/**
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int count = 0;
            long product = 1L;
            for (int j = i; j >= 0; j--) {
                product *= nums[j];
                if (product >= k) {
                    break;
                }
                count++;
            }
            dp[i + 1] = dp[i] + count;
        }
        return dp[n];
    }

    public int numSubarrayProductLessThanKSliding(int[] nums, int k) {
        int ans = 0;
        for (int i = 0, j = 0, prod = 1; i < nums.length; i++) {
            prod *= nums[i];
            while (j <= i && prod >= k) {
                prod /= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK spl = new SubarrayProductLessThanK();
        int[] nums = new int[] {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        int k = 18;
        System.out.println(spl.numSubarrayProductLessThanK(nums, k));
    }
}
