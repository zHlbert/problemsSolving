package contest.leetcode20220515;

/**
 * https://leetcode.cn/contest/weekly-contest-293/problems/largest-combination-with-bitwise-and-greater-than-zero/
 */
public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public int largestCombination(int[] candidates) {
        int res = 0;
        for (int i = 0; i < 29; i++) {
            int cnt = 0;
            for (int candidate : candidates) {
                if ((candidate >> i & 1) == 1) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
