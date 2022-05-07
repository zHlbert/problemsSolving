package leetcode._162;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return findPeakElement(nums, l, mid);
        } else {
            return findPeakElement(nums, mid + 1, r);
        }
    }

    public int findPeakElement1(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement1(new int[] {1,2,3,1}));
    }
}
