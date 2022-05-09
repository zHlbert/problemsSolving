package leetcode._153;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            int num = nums[mid];
            if (mid == lo) {
                return Math.min(num, nums[hi]);
            }
            if (num > nums[lo] && num > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public int findMin1(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fm = new FindMinimumInRotatedSortedArray();
        int[] nums = new int[] {2,1};
        System.out.println(fm.findMin1(nums));
    }
}
