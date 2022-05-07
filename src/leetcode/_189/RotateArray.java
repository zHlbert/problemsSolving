package leetcode._189;

import utils.ArrayUtils;

import java.util.Arrays;


/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int kn = k % n;
        if (kn == 0) {
            return;
        }
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);

        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = tmp[i];
        }
    }

    public void rotateByReverse(int[] nums, int k) {
        int n = nums.length;
        int kn = k % n;
        if (kn == 0) {
            return;
        }
        reverse(nums, 0, n);
        reverse(nums, 0, kn);
        reverse(nums, kn, n);
    }

    private void reverse(int[] nums, int begin, int end) {
        for (int i = begin; i < (begin + end) >> 1; i++) {
            swap(nums, i, end - 1 + begin - i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        ra.rotateByReverse(nums, k);
        ArrayUtils.printArray(nums);
    }
}
