package leetcode._1015;

import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerDivisibleByK {
    /**
     * https://leetcode.cn/problems/smallest-integer-divisible-by-k/solution/ke-bei-k-zheng-chu-de-zui-xiao-zheng-shu-ynog/
     * @param k
     * @return
     */
    public int smallestRepunitDivByK(int k) {
        int rem = 1 % k, len = 1;
        Set<Integer> set = new HashSet<>();
        set.add(rem);
        while (rem != 0) {
            rem = (rem * 10 + 1) % k;
            len++;
            if (set.contains(rem)) return -1;
            set.add(rem);
        }
        return len;
    }

    public int smallestRepunitDivByK1(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int rem = 1 % k, len = 1;
        while (rem != 0) {
            rem = (rem * 10 + 1) % k;
            len++;
        }
        return len;
    }
}
