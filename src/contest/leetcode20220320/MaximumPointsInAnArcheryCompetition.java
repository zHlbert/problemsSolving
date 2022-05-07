package contest.leetcode20220320;

import utils.ArrayUtils;

public class MaximumPointsInAnArcheryCompetition {
    public int[] maximumBobPointsEnum(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int maxScore = 0;
        int state = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int cnt = 0;
            int score = 0;
            for (int i = 0; i < n; i++) {
                if (cnt > numArrows) {
                    break;
                }
                if (((mask >> i) & 1) == 1) {
                    score += i;
                    cnt += aliceArrows[i] + 1;
                }
            }

            if (cnt <= numArrows && score > maxScore) {
                maxScore = score;
                state = mask;
            }
        }
        int[] ans = new int[aliceArrows.length];
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) {
                ans[i] = aliceArrows[i] + 1;
                numArrows -= ans[i];
            }
        }
        ans[0] += numArrows;
        return ans;
    }

    public int[] maximumBobPointsDP(int numArrows, int[] aliceArrows) {
        int[][] dp = new int[12][numArrows + 1];
        for (int i = 1; i < 12; i++) {
            int aa = aliceArrows[i];
            for (int j = 1; j <= numArrows; j++) {
                if (j < aa + 1) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - aa - 1] + i);
                }
            }
        }

        int[] ans = new int[aliceArrows.length];
        // 路径恢复
        for (int i = 11; i > 0; i--) {
            if (dp[i][numArrows] > dp[i - 1][numArrows]) {
                int aa = aliceArrows[i];
                ans[i] = aa + 1;
                numArrows -= ans[i];
            }
        }
        ans[0] += numArrows;
        return ans;
    }

    public static void main(String[] args) {
        MaximumPointsInAnArcheryCompetition m = new MaximumPointsInAnArcheryCompetition();
        int[] nums = new int[] {1,1,0,1,0,0,2,1,0,1,2,0};
        int numArrows = 9;
//        int[] nums = new int[] {0,0,1,0,0,0,0,0,0,0,0,2};
//        int numArrows = 3;
        ArrayUtils.printArray(m.maximumBobPointsDP(numArrows, nums));
    }
}
