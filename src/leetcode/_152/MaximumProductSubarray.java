package leetcode._152;

import utils.ArrayUtils;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int maxProd = nums[0];
        for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(nums[i], Math.max(nums[i] * maxDp[i - 1], nums[i] * minDp[i - 1]));
            minDp[i] = Math.min(nums[i], Math.min(nums[i] * maxDp[i - 1], nums[i] * minDp[i - 1]));
            maxProd = Math.max(maxProd, maxDp[i]);
        }

        return maxProd;
    }

    public int maxProductRolling(int[] nums) {
        int n = nums.length;
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            int mx = maxProd, mn = minProd;
            maxProd = Math.max(nums[i], Math.max(nums[i] * mx, nums[i] * mn));
            minProd = Math.min(nums[i], Math.min(nums[i] * mx, nums[i] * mn));
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        int[] nums = new int[] {-1,-2,-9,-6};
        System.out.println(mps.maxProductRolling(nums));
    }
}
