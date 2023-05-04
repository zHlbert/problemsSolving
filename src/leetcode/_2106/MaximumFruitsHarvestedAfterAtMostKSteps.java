package leetcode._2106;

import java.util.Arrays;

public class MaximumFruitsHarvestedAfterAtMostKSteps {
    /**
     * 二分
     * @param fruits
     * @param startPos
     * @param k
     * @return
     */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] fp = new int[n];
        int[] fs = new int[n + 1];
        for (int i = 0; i < fruits.length; i++) {
            int[] fruit = fruits[i];
            fp[i] = fruit[0];
            fs[i + 1] = fs[i] + fruit[1];
        }
        int maxP = fruits[n - 1][0];
//        System.out.println(Arrays.toString(fp));
//        System.out.println(Arrays.toString(fs));
        int res = 0;
        int leftPos = Math.max(0, startPos - k);
        for (int i = leftPos; i <= startPos; i++) {
            int li = lowerBound(fp, n, i);
            int lSum = fs[li];

            int rightPos = Math.min(Math.max(startPos, i + k - startPos + i), maxP);
            int ri = upperBound(fp, n, rightPos);
            int rSum = fs[Math.min(ri + 1, n)];

            res = Math.max(res, rSum - lSum);

//            System.out.println(Arrays.toString(new int[] {i, li, lSum, rightPos, ri, rSum, rSum - lSum}));
        }

        int rightPos = Math.min(maxP, startPos + k);
        for (int i = rightPos; i >= startPos; i--) {
            int ri = upperBound(fp, n, i);
            int rSum = fs[Math.min(ri + 1, n)];

            leftPos = Math.max(Math.min(startPos, i - k - startPos + i), 0);
            int li = lowerBound(fp, n, leftPos);
            int lSum = fs[li];

            res = Math.max(res, rSum - lSum);

//            System.out.println(Arrays.toString(new int[] {i, li, lSum, rightPos, ri, rSum, rSum - lSum}));
        }
        return res;
    }

    /**
     * arr 中满足 arr[i] <= t 的 最大下标 i
     * @param arr
     * @param n
     * @param t
     * @return
     */
    private int upperBound(int[] arr, int n, int t) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid] <= t) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return arr[l] <= t ? l : -1;
    }

    /**
     * arr 中满足 arr[i] >= t 的 最小下标 i
     * @param arr
     * @param n
     * @param t
     * @return
     */
    private int lowerBound(int[] arr, int n, int t) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l] >= t ? l : n;
    }

    public static void main(String[] args) {
        MaximumFruitsHarvestedAfterAtMostKSteps mf = new MaximumFruitsHarvestedAfterAtMostKSteps();
        System.out.println(mf.maxTotalFruits(new int[][] {{2,8},{6,3},{8,6}}, 5, 4));
        System.out.println(mf.maxTotalFruits(new int[][] {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}}, 5, 4));
        System.out.println(mf.maxTotalFruits(new int[][] {{200000,10000}}, 0, 0));
        System.out.println(mf.maxTotalFruits(new int[][] {{0,10000}}, 10000, 0));
        System.out.println(mf.maxTotalFruits(new int[][] {{0,7},{7,4},{9,10},{12,6},{14,8},{16,5},{17,8},{19,4},{20,1},{21,3},{24,3},{25,3},{26,1},{28,10},{30,9},{31,6},{32,1},{37,5},{40,9}}, 21, 30));
//        [[0,7},{7,4},{9,10},{12,6},{14,8},{16,5},{17,8},{19,4},{20,1},{21,3},{24,3},{25,3},{26,1},{28,10},{30,9},{31,6},{32,1},{37,5},{40,9]]
//        21
//        30
    }
}
