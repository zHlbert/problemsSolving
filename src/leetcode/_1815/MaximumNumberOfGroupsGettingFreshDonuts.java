package leetcode._1815;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/maximum-number-of-groups-getting-fresh-donuts/
 */
public class MaximumNumberOfGroupsGettingFreshDonuts {
    static final int WIDTH = 5;
    static final int WIDTH_MASK = (1 << WIDTH) - 1;

    /**
     * 记忆化搜索 + 状态压缩
     * https://leetcode.cn/problems/maximum-number-of-groups-getting-fresh-donuts/solution/de-dao-xin-xian-tian-tian-quan-de-zui-du-pzra/
     *
     * @param batchSize
     * @param groups
     * @return
     */
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] cnt = new int[batchSize];
        for (int x : groups) {
            cnt[x % batchSize]++;
        }

        long start = 0;
        for (int i = batchSize - 1; i >= 1; i--) {
            start = (start << WIDTH) | cnt[i];
        }

        Map<Long, Integer> memo = new HashMap<>();

        return dfs(memo, batchSize, start) + cnt[0];
    }

    private int dfs(Map<Long, Integer> memo, int batchSize, long mask) {
        if (mask == 0) return 0;
        if (!memo.containsKey(mask)) {
            long total = 0;
            for (int i = 1; i < batchSize; i++) {
                long amount = ((mask >> (i - 1) * WIDTH) & WIDTH_MASK);
                total += i * amount;
            }

            int best = 0;
            for (int i = 1; i < batchSize; i++) {
                long amount = ((mask >> (i - 1) * WIDTH) & WIDTH_MASK);
                if (amount > 0) {
                    int result = dfs(memo, batchSize, mask - (1L << ((i - 1) * WIDTH)));
                    if ((total - i) % batchSize == 0) {
                        result++;
                    }
                    best = Math.max(best, result);
                }
            }
            memo.put(mask, best);
        }
        return memo.get(mask);
    }
}
