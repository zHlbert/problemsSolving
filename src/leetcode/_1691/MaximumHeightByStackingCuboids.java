package leetcode._1691;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * 堆叠长方体的最大高度
 * https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/
 */
public class MaximumHeightByStackingCuboids {
    /**
     * 排序 + 动态规划
     * @param cuboids
     * @return
     */
    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (c, d) -> {
            if (c[2] != d[2]) {
                return d[2] - c[2];
            }
            if (c[1] != d[1]) {
                return d[1] - c[1];
            }
            return d[0] - c[0];
        });

//        ArrayUtils.print2DArray(cuboids);

        int n = cuboids.length;
        int[][] dp = new int[n][2];
        dp[0][1] = cuboids[0][2];
        for (int i = 1; i < n; i++) {
            dp[i][1] = cuboids[i][2];
            for (int j = i - 1; j >= 0; j--) {
                if (cuboids[i][1] <= cuboids[j][1] && cuboids[i][0] <= cuboids[j][0]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + cuboids[i][2]);
                }
                dp[i][0] = Math.max(dp[i][0], Math.max(dp[j][0], dp[j][1]));
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int maxHeight1(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (c, d) -> c[0] + c[1] + c[2] - d[0] - d[1] - d[2]);

        int res = 0, n = cuboids.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] >= cuboids[j][0]
                    && cuboids[i][1] >= cuboids[j][1]
                    && cuboids[i][2] >= cuboids[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumHeightByStackingCuboids mh = new MaximumHeightByStackingCuboids();
        int[][] cuboids = new int[][] {{50,45,20},{95,37,53},{45,23,12}};
//        int[][] cuboids = new int[][] {{38,25,45},{76,35,3}};
//        int[][] cuboids = new int[][] {{7,11,17},{7,17,11},{11,7,17},{11,17,7},{17,7,11},{17,11,7}};
//        int[][] cuboids = new int[][] {{50,26,84},{2,55,62},{64,63,72}};
        System.out.println(mh.maxHeight(cuboids));
    }
}
