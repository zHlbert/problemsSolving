package leetcode._1335;

import java.util.Arrays;

public class MinimumDifficultyOfAJobSchedule {
    /**
     * 区间dp
     * https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/solution/gong-zuo-ji-hua-de-zui-di-nan-du-by-leet-dule/
     * @param jobDifficulty
     * @param d
     * @return
     */
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        int[] dp = new int[n];
        for (int i = 0, mx = 0; i < n; i++) {
            mx = Math.max(mx, jobDifficulty[i]);
            dp[i] = mx;
        }
        for (int i = 1; i < d; i++) {
            int[] ndp = new int[n];
            Arrays.fill(ndp, 0x3f3f3f3f);
            for (int j = i; j < n; j++) {
                int mx = 0;
                for (int k = j; k >= i; k--) {
                    mx = Math.max(mx, jobDifficulty[k]);
                    ndp[j] = Math.min(ndp[j], mx + dp[k - 1]);
                }
            }
            dp = ndp;
        }
        return dp[n - 1];
    }

    // TODO: 2023/5/16 单调栈

    public static void main(String[] args) {
        MinimumDifficultyOfAJobSchedule md = new MinimumDifficultyOfAJobSchedule();
        System.out.println(md.minDifficulty(new int[] {6,5,4,3,2,1}, 2));
        System.out.println(md.minDifficulty(new int[] {9,9,9}, 4));
        System.out.println(md.minDifficulty(new int[] {1,1,1}, 3));
    }
}
