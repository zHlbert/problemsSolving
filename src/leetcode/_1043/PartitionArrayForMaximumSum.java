package leetcode._1043;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    /**
     * 动态规划
     * @param arr
     * @param k
     * @return
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int mx = 0, dp0 = 0;
            for (int j = 1; j <= Math.min(k, i); j++) {
                mx = Math.max(mx, arr[i - j]);
                dp0 = Math.max(dp0, j * mx + dp[i - j]);
            }
            dp[i] = dp0;
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        PartitionArrayForMaximumSum pa = new PartitionArrayForMaximumSum();
        System.out.println(pa.maxSumAfterPartitioning(new int[] {1,15,7,9,2,5,10}, 3));
        System.out.println(pa.maxSumAfterPartitioning(new int[] {1,4,1,5,7,3,6,1,9,9,3}, 4));
        System.out.println(pa.maxSumAfterPartitioning(new int[] {1}, 1));
    }
}
