package leetcode._1040;

import java.util.Arrays;

public class MovingStonesUntilConsecutiveII {

    /**
     * https://leetcode.cn/problems/moving-stones-until-consecutive-ii/solution/yi-dong-shi-zi-zhi-dao-lian-xu-ii-by-lee-8u5g/
     * @param stones
     * @return
     */
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        if (stones[n - 1] - stones[0] + 1 == n) return new int[2];
        int mx = Math.max(stones[n - 2] - stones[0] + 1, stones[n - 1] - stones[1] + 1) - (n - 1);
        int mn = n;
        for (int i = 0, j = 0; i < n && j + 1 < n; i++) {
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n)
                j++;
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1)
                mn = Math.min(mn, 2);
            else mn = Math.min(mn, n - (j - i + 1));
        }
        return new int[] {mn, mx};
    }
}
