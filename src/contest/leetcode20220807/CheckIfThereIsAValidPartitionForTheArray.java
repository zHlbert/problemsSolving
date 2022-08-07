package contest.leetcode20220807;

import java.util.Arrays;

public class CheckIfThereIsAValidPartitionForTheArray {
//    public boolean validPartition(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        return partition(nums, 0, n);
////        return true;
//    }
//
//    private boolean partition(int[] nums, int l, int r) {
//        if (l + 2 > r) {
//            return false;
//        }
//        if (l + 2 == r) {
//            return nums[l] == nums[l + 1];
//        }
//        if (l + 3 == r) {
//            return nums[l] == nums[l + 1] && nums[l] == nums[l + 2]
//                    || nums[l] + 1 == nums[l + 1] && nums[l] + 2 == nums[l + 2];
//        }
//        return partition(nums, l, l + 2) && partition(nums, l + 2, r)
//                || partition(nums, l, l + 3) && partition(nums, l + 3, r);
//    }

    /**
     * dp
     * @param nums
     * @return
     */
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (i >= 2 && nums[i - 1] == nums[i - 2]) {
                dp[i] = dp[i] | dp[i - 2];
            }
            if (i >= 3 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3]) {
                dp[i] = dp[i] | dp[i - 3];
            }
            if (i >= 3 && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1) {
                dp[i] = dp[i] | dp[i - 3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CheckIfThereIsAValidPartitionForTheArray cv = new CheckIfThereIsAValidPartitionForTheArray();
        int[] nums = new int[] {4,4,4,5,6};
        System.out.println(cv.validPartition(nums));
    }
}
