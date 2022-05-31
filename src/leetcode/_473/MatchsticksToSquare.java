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
            if (lens[i] + matchsticks[idx] <= edge) {
                lens[i] += matchsticks[idx];
                if (backtrack(matchsticks, idx + 1, lens)) {
                    return true;
                }
                lens[i] -= matchsticks[idx];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MatchsticksToSquare ms = new MatchsticksToSquare();
//        int[] matchsticks = new int[] {1,1,2,2,2};
        int[] matchsticks = new int[] {3,3,3,3,4};
//        int[] matchsticks = new int[] {5969561,8742425,2513572,3352059,9084275,2194427,1017540,2324577,6810719,8936380,7868365,2755770,9954463,9912280,4713511};
//        int[] matchsticks = new int[] {10,6,5,5,5,3,3,3,2,2,2,2};
//        int[] matchsticks = new int[] {1,1,2,2,2};
        System.out.println(ms.makesquare(matchsticks));
    }
}
