package leetcode._16;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        int minGap = Math.abs(target - closestSum);
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                int curGap = Math.abs(target - curSum);
                if (curGap < minGap) {
                    minGap = curGap;
                    closestSum = curSum;
                }
                if (curSum < target) {
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                } else if (curSum > target) {
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                } else {
                    return target;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
//        int[] nums = new int[] {-1,2,1,-1};
//        int target = 1;
        int[] nums = new int[] {0,0,0};
        int target = 1;
        System.out.println(tsc.threeSumClosest(nums, target));
    }
}
