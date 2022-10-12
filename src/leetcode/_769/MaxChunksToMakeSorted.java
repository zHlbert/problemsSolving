package leetcode._769;

import java.util.Arrays;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[][][] mm = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mm[i][j][0] = 0;
                mm[i][j][1] = 10;
            }
        }
        for (int i = 0; i < n; i++) {
            mm[i][i][0] = arr[i];
            for (int j = i + 1; j < n; j++) {
                mm[i][j][0] = Math.max(mm[i][j - 1][0], arr[j]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            mm[i][i][1] = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                mm[j][i][1] = Math.min(mm[j + 1][i][1], arr[j]);
            }
        }

        int res = 0, cur = 0;
        for (int i = 0; i < n - 1; i++) {
            if (mm[cur][i][0] < mm[i + 1][n - 1][1]) {
                res++;
                cur = i + 1;
            }
        }
        return res + 1;
    }

    /**
     * 贪心
     * @param arr
     * @return
     */
    public int maxChunksToSorted1(int[] arr) {
        int res = 0, mx = 0;
        for (int i = 0; i < arr.length; i++) {
            mx = Math.max(mx, arr[i]);
            res += mx == i ? 1 : -0;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted mc = new MaxChunksToMakeSorted();
        System.out.println(mc.maxChunksToSorted(new int[] {4,3,2,1,0}));
        System.out.println(mc.maxChunksToSorted(new int[] {1,0,2,3,4}));
        System.out.println(mc.maxChunksToSorted(new int[] {1,0,4,2,3}));
    }
}
