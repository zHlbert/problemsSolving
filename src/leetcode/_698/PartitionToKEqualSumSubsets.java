package leetcode._698;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */
public class PartitionToKEqualSumSubsets {
    int n, target, k;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        if (n < k) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        target = sum / k;
        this.k = k;
        Arrays.sort(nums);
        return backtrack(nums, new int[k], n - 1);
    }

    private boolean backtrack(int[] nums, int[] sums, int idx) {
        if (idx == -1) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            // 剪枝
            if (i > 0 && sums[i] == sums[i - 1]) {
                continue;
            }
            if (sums[i] + nums[idx] <= target) {
                sums[i] += nums[idx];
                if (backtrack(nums, sums, idx - 1)) {
                    return true;
                }
                sums[i] -= nums[idx];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets pke = new PartitionToKEqualSumSubsets();
//        int[] nums = new int[] {4,3,2,3,5,2,1};
//        int k = 4;
//        int[] nums = new int[] {1,2,3,4};
//        int k = 3;
        int[] nums = new int[] {2,2,2,2,3,4,5};
        int k = 4;
        System.out.println(pke.canPartitionKSubsets(nums, k));
    }
}
