package leetcode._1140;

import java.util.HashMap;
import java.util.Map;

public class StoneGameII {
    Map<Integer, Integer> memo = new HashMap<>();
    int[] prefix;
    int[] piles;
    int n;

    /**
     * 记忆化搜索
     * @param piles
     * @return
     */
    public int stoneGameII(int[] piles) {
        this.piles = piles;
        n = piles.length;
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + piles[i];
        }

        return (prefix[n] + dp(0, 1)) >> 1;
    }

    /**
     * 表示前 i 堆石头已经被取走，当前的 M=m 的情况下，接下去取石头的玩家可以比另一方多取的石头数
     * @param i
     * @param m
     * @return
     */
    private int dp(int i, int m) {
        if (i == n) return 0;
        int key = 210 * i + m;
        if (!memo.containsKey(key)) {
            int maxVal = Integer.MIN_VALUE;
            for (int x = 1; x <= 2 * m; x++) {
                if (i + x > n) break;
                maxVal = Math.max(maxVal, prefix[i + x] - prefix[i] - dp(i + x, Math.max(m, x)));
            }
            memo.put(key, maxVal);
        }
        return memo.get(key);
    }
}
