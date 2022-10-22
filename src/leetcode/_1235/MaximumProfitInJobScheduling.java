package leetcode._1235;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    /**
     * 序列DP
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 结束时间 <= jobs[i - 1] 的开始时间的 工作个数
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            System.out.println(k);
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    private int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (jobs[mid][1] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // 判断当前工作结束时间是否 <= target, 是的话加上自己
        return jobs[left][1] <= target ? left + 1 : left;
    }

    private int binarySearch1(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + right >> 1;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling mp = new MaximumProfitInJobScheduling();
        int[] startTime = new int[] {1,1,1};
        int[] endTime = new int[] {2,3,4};
        int[] profit = new int[] {5,6,4};
//        int[] startTime = new int[] {1,2,3,3};
//        int[] endTime = new int[] {3,4,5,6};
//        int[] profit = new int[] {50,10,40,70};
        System.out.println(mp.jobScheduling(startTime, endTime, profit));
    }
}
