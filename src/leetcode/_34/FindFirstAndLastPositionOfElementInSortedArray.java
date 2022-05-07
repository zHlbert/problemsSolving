package leetcode._34;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 7;
        int[] result = searchRange(nums, target);
        for (int j : result) {
            System.out.println(j);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
//        int length = nums.length;
//        if (length == 0 || target < nums[0] || target > nums[length - 1]) {
//            return result;
//        }
//        result[0] = getIndex(nums, target, 0, length - 1, true);
//        result[1] = getIndex(nums, target, 0, length - 1, false);

        int leftIndex = getIndex(nums, target, true);

        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return result;
        }

        result[0] = leftIndex;
        result[1] = getIndex(nums, target, false) - 1;

        return result;
    }

    private static int getIndex(int[] nums, int target, int start, int end, boolean left) {
        if (nums[start] == target) {
            return start;
        } else if (end <= start + 1 && nums[start] != target) {
            return -1;
        }
        int mid = (start + end) / 2;

        int result = -1;
        if (nums[mid] > target) {
            result = getIndex(nums, target, start, mid, left);
        } else {
            result = getIndex(nums , target, mid, end, left);
        }
        return result;
    }

    private static int getIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public void test() {
//        List<ListNode> list = new ArrayList<ListNode>();
    }
}
