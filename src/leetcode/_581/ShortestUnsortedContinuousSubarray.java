package leetcode._581;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarrayBySorting(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int n = nums.length;
        int[] sorted = new int[n];
        System.arraycopy(nums, 0, sorted, 0, n);
        Arrays.sort(sorted);
        int left = 0;
        while (nums[left] == sorted[left]) {
            left++;
        }
        int right = n - 1;
        while (nums[right] == sorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        int left = -1, right = -1;
        for (int i = 0; i < n; i++) {
            // (right, n - 1]区间中数都大于[0, right]中的最大值
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }
            // [0, left)区间中数都小于[left, n - 1]中的最小值
            if (nums[n - 1 - i] <= min) {
                min = nums[n - 1 - i];
            } else {
                left = n - 1 - i;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
