package leetcode._18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sum/
 */
public class FourSum {
    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long)nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long)nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                long nt = (long) target - nums[i] - nums[j];
                for (int l = j + 1, r = n - 1; l < n - 1; l++) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) {
                        continue;
                    }
                    if (nums[l] + nums[r] < nt) {
                        continue;
                    }
                    while (l < r && nums[l] + nums[r] > nt) {
                        r--;
                    }
                    if (l == r) {
                        break;
                    }
                    if (nums[l] + nums[r] == nt) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                    }
                }
            }
        }
        return res;
    }
}
