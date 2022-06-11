package contest.leetcode20220611;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        long res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j <= i && (preSum[i + 1] - preSum[j]) * (i - j + 1) >= k) {
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubarraysWithScoreLessThanK cs = new CountSubarraysWithScoreLessThanK();
        int[] nums = new int[] {2,1,4,3,5};
        int k = 10;
//        int[] nums = new int[] {1,1,1};
//        int k = 5;
//        [5,2,6,8,9,7]
//        13
//        int[] nums = new int[] {5,2,6,8,9,7};
//        int k = 50;
        System.out.println(cs.countSubarrays(nums, k));
    }
}
