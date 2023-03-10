package leetcode._1590;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {
    /**
     * 哈希 + 前缀和
     * @param nums
     * @param p
     * @return
     */
    public int minSubarray(int[] nums, int p) {
        int x = 0, n = nums.length;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) return 0;
        Map<Integer, Integer> idx = new HashMap<>();
        int y = 0, res = n;
        for (int i = 0; i < n; i++) {
            idx.put(y, i);
            y = (y + nums[i]) % p;
            if (idx.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - idx.get((y - x + p) % p) + 1);
            }
        }
        return res == n ? -1 : res;
    }
}
