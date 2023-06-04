package leetcode._2460;

public class ApplyOperationsToAnArray {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (i < n - 1 && nums[i] != 0 && nums[i] == nums[i + 1]) {
                nums[i] += nums[i];
                nums[i + 1] = 0;
            }
        }
        int[] res = new int[n];
        int j = 0;
        for (int num : nums)
            if (num != 0)
                res[j++] = num;
        return res;
    }
}
