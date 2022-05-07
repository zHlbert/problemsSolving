package contest.leetcode20210815;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a 0-indexed array nums of distinct integers. You want to rearrange the elements in the array such that every element in the rearranged array is not equal to the average of its neighbors.
 *
 * More formally, the rearranged array should have the property such that for every i in the range 1 <= i < nums.length - 1, (nums[i-1] + nums[i+1]) / 2 is not equal to nums[i].
 *
 * Return any rearrangement of nums that meets the requirements
 */
public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i + 1] + nums[i - 1] == 2 * nums[i]) {
                for (int j = 1; j < len; j++) {
                    int i1 = (i + 1 + j) % len;
                    if (nums[i1] != nums[i + 1] && i1 != i - 1 && nums[i1] + nums[i - 1] != 2 * nums[i]) {
                        swap(nums, i + 1, i1);
                        break;
                    }
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    /**
     * 0,4,1,5,3
     * 1,2,3,4,5
     * 1,2,3
     * @param args
     */

    public static void main(String[] args) {
        ArrayWithElementsNotEqualToAverageOfNeighbors a = new ArrayWithElementsNotEqualToAverageOfNeighbors();
        int[] nums = new int[] {0,4,1,5,3};
        ArrayUtils.printArray(a.rearrangeArray(nums));
    }
}
