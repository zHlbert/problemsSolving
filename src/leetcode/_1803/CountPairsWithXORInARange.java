package leetcode._1803;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计异或值在范围内的数对有多少
 * https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/
 */
public class CountPairsWithXORInARange {
    /**
     * 哈希
     * https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/solution/bu-hui-zi-dian-shu-zhi-yong-ha-xi-biao-y-p2pu/
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        for (++high; high > 0; high >>= 1, low >>= 1) {
            Map<Integer, Integer> nxt = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int x = entry.getKey(), c = entry.getValue();
                res += c * (high % 2 * cnt.getOrDefault((high - 1) ^ x, 0)
                        - low % 2 * cnt.getOrDefault((low - 1) ^ x, 0));
                nxt.put(x >> 1, nxt.getOrDefault(x >> 1, 0) + c);
            }
            cnt = nxt;
        }
        return res / 2;
    }

    // TODO: 2023/1/5 字典树
}
