package leetcode._324;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/wiggle-sort-ii/
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
//        for (int i = 1, j = n / 2 + 1; i < n && j < n; i += 2, j++) {
//            if (nums[j] > nums[i])
//                swap(nums, i, j);
//        }

        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        WiggleSortII ws = new WiggleSortII();
        int[] nums = new int[] {1,5,1,1,6,4};
//        int[] nums = new int[] {1,3,2,2,3,1};
//        int[] nums = new int[] {1,4,3,4,1,2,1,3,1,3,2,3,3};
        ws.wiggleSort(nums);
        ArrayUtils.printArray(nums);
    }
}
