package leetcode._2389;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    /**
     * 二分
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int l = 0, r = n;
            // 求出 小于等于 q 的最大下标
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (prefix[mid] <= q) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            res[i] = l;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubsequenceWithLimitedSum ls = new LongestSubsequenceWithLimitedSum();
        System.out.println(Arrays.toString(ls.answerQueries(new int[] {4,5,2,1}, new int[] {3,10,21})));
        System.out.println(Arrays.toString(ls.answerQueries(new int[] {2,3,4,5}, new int[] {1})));
    }
}
