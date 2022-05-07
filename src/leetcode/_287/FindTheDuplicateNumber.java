package leetcode._287;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for (int num : nums) {
            if (numSet.contains(num)) {
                return num;
            }
            numSet.add(num);
        }
        return 1;
    }

    /**
     * 我们定义 \textit{cnt}[i]cnt[i] 表示 \textit{nums}nums 数组中小于等于 ii 的数有多少个，假设我们重复的数是 \textit{target}target，那么 [1,\textit{target}-1][1,target−1]里的所有数满足 \textit{cnt}[i]\le icnt[i]≤i，[target,n][target,n] 里的所有数满足 \textit{cnt}[i]>icnt[i]>i，具有单调性。
     *
     *
     * @param nums
     * @return
     */
    public int findDuplicateBinarySearch(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid)
                    cnt++;
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    // 快慢指针
}
