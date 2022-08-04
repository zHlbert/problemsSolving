package leetcode._1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {
    /**
     * 贪心
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1, curSum = 0; i >= 0; i--) {
            if (curSum + curSum > sum) {
                break;
            }
            res.add(nums[i]);
            curSum += nums[i];
        }
        return res;
    }
}
