package leetcode._1186;

public class MaximumSubArraySumWithOneDeletion {
    /**
     * 动态规划
     * dp0 表示当前不删除元素的最大值，dp1 表示删除1个元素的最大值
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        int n = arr.length, res = arr[0];
        int dp0 = arr[0], dp1 = 0;
        for (int i = 1; i < n; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }

}
