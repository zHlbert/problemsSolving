package leetcode._33;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInRotatedSortedArray {
    int k = 0;

    public int search(int[] nums, int target) {
        int len = nums.length;
        findK(nums, 0, len);
        int l = search(nums, target, 0, len - k);
        int r = search(nums, target, len - k, len);
        return l == r ? -1
                : l != -1 ? l : r;
    }

    private void findK(int[] nums, int start, int end) {
        if (k != 0 || start == end) {
            return;
        }
        if (start == end - 1) {
            if (start < nums.length - 1 && nums[start] > nums[start + 1]) {
                k = nums.length - 1 - start;
                return;
            }
        }
        if (start + 2 >= end) {
            k = nums[start] > nums[end - 1] ? nums.length - 1 - start : 0;
            if (end < nums.length && nums[end - 1] > nums[end]) {
                k = nums.length - end;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        findK(nums, start, mid);
        findK(nums, mid, end);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start == end) {
            return -1;
        }
        if (start + 1 >= end) {
            return target == nums[start] ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return search(nums, target, start, mid);
        } else {
            return search(nums, target, mid, end);
        }
    }

    public int search1(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 2);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return  -1;
    }

    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] nums = new int[] {4,5,6,7,8,9,1,2,3};
        System.out.println(s.search1(nums, 1));
    }
}
