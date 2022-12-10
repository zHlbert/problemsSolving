package leetcode._1827;

public class MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}
