package leetcode._1726;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                Integer cnt = cntMap.getOrDefault(prod, 0);
                cntMap.put(prod, cnt + 1);
            }
        }

        int res = 0;
        for (Integer cnt : cntMap.values()) {
            if (cnt >= 2) {
                res += cnt * (cnt - 1) * 4;
            }
        }
        return res;
    }
}
