package contest.leetcode20220717;

import java.util.Arrays;

public class QueryKthSmallestTrimmedNumber {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int q = queries.length;
        int[] res = new int[q];
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int j = 0; j < n; j++) {
            idx[j] = j;
        }
        int m = nums[0].length();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int k = query[0], trim = query[1];

            Arrays.sort(idx, (a, b) -> {
                char[] ca = nums[a].toCharArray();
                char[] cb = nums[b].toCharArray();
                for (int j = m - trim; j < m; j++) {
                    if (ca[j] != cb[j]) {
                        return ca[j] - cb[j];
                    }
                }
                return a - b;
            });
            res[i] = idx[k - 1];
        }

        return res;
    }
}
