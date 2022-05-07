package leetcode;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
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

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray mlrs = new MaximumLengthOfRepeatedSubarray();
//        int[] nums1 = new int[] {1,2,3,2,1};
//        int[] nums2 = new int[] {3,2,1,4,7};
        int[] nums1 = new int[] {0,1,1,1,1};
        int[] nums2 = new int[] {1,0,1,0,1};
        System.out.println(mlrs.findLength(nums1, nums2));
    }
}
