package contest.leetcode20220515;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-293/problems/maximum-consecutive-floors-without-special-floors/
 */
public class MaximumConsecutiveFloorsWithoutSpecialFloors {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int maxLen = 0;
        maxLen = Math.max(maxLen, special[0] - bottom);
        int n = special.length;
        for (int i = 1; i < n; i++) {
            maxLen = Math.max(maxLen, special[i] - special[i - 1] - 1);
        }
        maxLen = Math.max(maxLen, top - special[n - 1]);
        return maxLen;
    }

    public static void main(String[] args) {
        MaximumConsecutiveFloorsWithoutSpecialFloors mc = new MaximumConsecutiveFloorsWithoutSpecialFloors();
//        int bottom = 2, top = 9;
//        int[] special = new int[] {4,6};
        int bottom = 6, top = 6;
        int[] special = new int[] {7,6,8};
        System.out.println(mc.maxConsecutive(bottom, top, special));
    }
}
