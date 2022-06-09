package leetcode._209;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0, minL = n + 1;
        // 滑动窗口
        for (int i = 0, j = 0; i < n; i++) {
            sum += nums[i];
            while (j <= i && sum >= target) {
                minL = Math.min(minL, i - j + 1);
                sum -= nums[j++];
            }
        }
        return minL < n + 1 ? minL : 0;
    }

    public int minSubArrayLenPreSum(int target, int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int minL = n + 1;
        for (int i = 0; i < n; i++) {
            int t = binarySearch(target + preSum[i], preSum, i + 1, n);
//            int t = lowerBound(preSum, i + 1, n, target + preSum[i]);
            if (t != -1) {
                minL = Math.min(minL, t - i);
            }
        }
        return minL < n + 1 ? minL : 0;
    }

    /**
     * 寻找 大于等于 target 的最小下标
     * @param target
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int binarySearch(int target, int[] arr, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] >= target ? l : -1;
    }

    private int lowerBound(int[] a, int l, int r, int target)
    {
        int mid = -1, originL = l, originR = r;
        while (l < r)
        {
            mid = (l + r) >> 1;
            if (a[mid] < target) l = mid + 1;
            else r = mid;
        }

        return (a[l] >= target) ? l : -1;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
        int target = 4;
        int[] nums = new int[] {1,4,4};
        System.out.println(ms.minSubArrayLenPreSum(target, nums));
    }
}
