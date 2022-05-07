package leetcode._905;

import utils.ArrayUtils;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            while (nums[head] % 2 == 0 && head < tail) {
                head++;
            }
            while (nums[tail] % 2 == 1 && head < tail) {
                tail--;
            }
            if (head < tail) {
                swap(nums, head, tail);
                head++;
                tail--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        SortArrayByParity sap = new SortArrayByParity();
//        int[] nums = new int[] {3,1,2,4};
        int[] nums = new int[] {4};
        int[] nums1 = sap.sortArrayByParity(nums);
        ArrayUtils.printArray(nums1);
        int[] nums2 = sap.sortArrayByParity(nums1);
        ArrayUtils.printArray(nums2);
    }
}
