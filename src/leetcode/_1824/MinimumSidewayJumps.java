package leetcode._1824;

import java.util.Arrays;

/**
 * 最少侧跳次数
 * https://leetcode.cn/problems/minimum-sideway-jumps/
 */
public class MinimumSidewayJumps {
    /**
     * 动态规划
     * @param obstacles
     * @return
     */
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] jumps = new int[] {1, 0, 1};
        for (int i = 1; i < n; i++) {
            int minCnt = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) jumps[j] = Integer.MAX_VALUE;
                else minCnt = Math.min(minCnt, jumps[j]);
            }
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) continue;
                jumps[j] = Math.min(jumps[j], minCnt + 1);
            }
        }
//        System.out.println(Arrays.toString(jumps));
        return Math.min(jumps[0], Math.min(jumps[1], jumps[2]));
    }

    public static void main(String[] args) {
        MinimumSidewayJumps msj = new MinimumSidewayJumps();
        System.out.println(msj.minSideJumps(new int[] {0,1,2,3,0}));
        System.out.println(msj.minSideJumps(new int[] {0,1,1,3,3,0}));
    }
}
