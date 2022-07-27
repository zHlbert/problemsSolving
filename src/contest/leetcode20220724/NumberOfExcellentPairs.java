package contest.leetcode20220724;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/number-of-excellent-pairs/
 */
public class NumberOfExcellentPairs {
    public static int maxp = 30;

    /**
     * 讨论二进制第 i 位在 num1 和 num2 中是否为 1 的情况：
     *
     * 若第 i 位的 1 只在 num1 和 num2 中出现一次，则它只会在 num1 OR num2 的结果中出现，对位数之和的贡献是 1；
     * 若第 i 位的 1 在 num1 和 num2 中出现两次，则它会在 num1 OR num2 和 num1 AND num2 的结果中出现，对位数之和的贡献是 22。
     * 也就是说，第 i 位在两个数里出现几次，它的贡献就是几。因此我们维护 f(x) 表示数 xx 中有几个 1，题目变为：
     *
     * 求不同数对 (x, y) 的数量，使得 f(x) + f(y) ≥ k。
     * @param nums
     * @param k
     * @return
     */
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] cnts = new int[maxp + 1];
        for (int num : set) {
            int sum1 = 0;
            for (int i = 0; i <= maxp; i++) {
                sum1 += (num >> i) & 1;
            }
            cnts[sum1]++;
        }

        long res  = 0;
        for (int i = 0; i <= maxp; i++) {
            for (int j = 0; j <= maxp; j++) {
                if (i + j >= k) {
                    res += (long) cnts[i] * cnts[j];
                }
            }
        }
        return res;
    }
}
