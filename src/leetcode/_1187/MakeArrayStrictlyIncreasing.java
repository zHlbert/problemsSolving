package leetcode._1187;

import java.util.Arrays;

public class MakeArrayStrictlyIncreasing {
    static int INF = 0x3f3f3f3f;

    /**
     * https://leetcode.cn/problems/make-array-strictly-increasing/solution/shi-shu-zu-yan-ge-di-zeng-by-leetcode-so-6p94/
     * 动态规划 +　二分查找
     * @param arr1
     * @param arr2
     * @return
     */
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int pre = -1;
        int[] uniqArr2 = new int[arr2.length];
        int m = 0;
        for (int x : arr2) {
            if (x != pre) {
                uniqArr2[m++] = x;
                pre = x;
            }
        }
        int[] newArr1 = new int[arr1.length + 2];
        int n = newArr1.length;
        newArr1[0] = -1;
        newArr1[n - 1] = INF;
        System.arraycopy(arr1, 0, newArr1, 1, n - 2);
        System.out.println(Arrays.toString(newArr1) + ", " + n);
        System.out.println(Arrays.toString(uniqArr2) + ", " + m);

        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (newArr1[i - 1] < newArr1[i]) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            int k = lowerBound(uniqArr2, newArr1[i], m);
            for (int j = 1; j <= Math.min(i - 1, k); j++) {
                if (newArr1[i - j - 1] < uniqArr2[k - j]) {
                    dp[i] = Math.min(dp[i], dp[i - j - 1] + j);
                }
            }
        }
        return dp[n - 1] == INF ? -1 : dp[n - 1];
    }

    private int lowerBound(int[] arr, int t, int m) {
        int l = 0, r = m;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        MakeArrayStrictlyIncreasing ma = new MakeArrayStrictlyIncreasing();
        System.out.println(ma.makeArrayIncreasing(new int[] {1,5,3,6,7}, new int[] {4,3,1}));
    }
}
