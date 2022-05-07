package leetcode._31;

import utils.ArrayUtils;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 反转nums的[begin, end)区间内元素
     * @param nums
     * @param begin
     * @param end
     */
    private void reverse(int[] nums, int begin, int end) {
        for (int i = begin; i < (begin + end) >> 1; i++) {
            swap(nums, i, end - 1 + begin - i);
        }
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = new int[] {1,4,3,5,7,2};
        n.nextPermutation(nums);
        ArrayUtils.printArray(nums);
    }
}
