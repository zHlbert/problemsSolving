package leetcode._473;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/matchsticks-to-square/
 */
public class MatchsticksToSquare {
    int edge;
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int sum = 0, max = 0;
        for (int stick : matchsticks) {
            sum += stick;
            max = Math.max(max, stick);
        }
        if (sum % 4 != 0 || (edge = sum >> 2) < max) {
            return false;
        }
        int[] lens = new int[4];
        Arrays.sort(matchsticks);
        // 反转，使之倒序
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
        }
        return backtrack(matchsticks, 0, lens);
    }

    private boolean backtrack(int[] matchsticks, int idx, int[] lens) {
        if (idx == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            // 剪枝 如果把当前火柴放到lens[i]这个边上，他的长度大于边长，直接跳过
            // 剪枝 lens[i] == lens[i - 1] 即上一个分支的值和当前分支的一样，上一个分支没有成功，
            // 说明这个分支也不会成功，直接跳过即可
            if (lens[i] + matchsticks[idx] > edge || (i > 0 && lens[i] == lens[i - 1])) {
                continue;
            }
            lens[i] += matchsticks[idx];
            if (backtrack(matchsticks, idx + 1, lens)) {
                return true;
            }
            lens[i] -= matchsticks[idx];
        }
        return false;
    }

    /**
     * 状态压缩 + 动态规划 复杂度 (n * 2 ^ n)
     * @param matchsticks
     * @return
     */
    public boolean makesquareDP(int[] matchsticks) {
        int n = matchsticks.length;
        if (n < 4) {
            return false;
        }
        int sum = 0, max = 0;
        for (int stick : matchsticks) {
            sum += stick;
            max = Math.max(max, stick);
        }
        int len;
        if (sum % 4 != 0 || (len = sum >> 2) < max) {
            return false;
        }
        // dp[s] 表示 状态为 s 时边的当前长度，如果已满，则dp[s] = 0;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                // 第k位置为0，看使用这根火柴之前的长度 加上 这根火柴的长度 是否小于等于一条边
                int s0 = s & ~(1 << k);
                int sum0;
                if (dp[s0] >= 0 && (sum0 = dp[s0] + matchsticks[k]) <= len) {
                    dp[s] = (sum0 == len ? 0 : sum0);
                    break;
                }
            }
        }

        return dp[(1 << n) - 1] == 0;
    }

    public static void main(String[] args) {
        MatchsticksToSquare ms = new MatchsticksToSquare();
//        int[] matchsticks = new int[] {1,1,2,2,2};
//        int[] matchsticks = new int[] {3,3,3,3,4};
//        int[] matchsticks = new int[] {5969561,8742425,2513572,3352059,9084275,2194427,1017540,2324577,6810719,8936380,7868365,2755770,9954463,9912280,4713511};
//        int[] matchsticks = new int[] {10,6,5,5,5,3,3,3,2,2,2,2};
        int[] matchsticks = new int[] {1,1,2,2,2};
        System.out.println(ms.makesquare(matchsticks));
    }
}
