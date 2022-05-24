package leetcode._718;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxL = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                maxL = Math.max(maxL, dp[i + 1][j + 1]);
            }
        }
        return maxL;
    }

    public int findLengthSliding(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int len = Math.min(m - i, n);
            int maxL = maxLength(nums1, nums2, i, 0, len);
            ans = Math.max(ans, maxL);
        }

        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxL = maxLength(nums1, nums2, 0, i, len);
            ans = Math.max(ans, maxL);
        }
        return ans;
    }

    private int maxLength(int[] nums1, int[] nums2, int d1, int d2, int len) {
        int ans = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[d1 + i] == nums2[d2 + i]) {
                k++;
            } else {
                k = 0;
            }
            ans = Math.max(ans, k);
        }
        return ans;
    }
}
