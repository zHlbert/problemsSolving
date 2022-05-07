package leetcode._53;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxNum = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            maxNum = Math.max(maxNum, pre);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        System.out.println(m.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
