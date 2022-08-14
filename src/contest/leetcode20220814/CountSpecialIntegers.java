package contest.leetcode20220814;

import java.util.*;

/**
 * https://leetcode.cn/problems/count-special-integers/
 */
public class CountSpecialIntegers {
    /**
     * 数位DP
     * @param n
     * @return
     */
    public int countSpecialNumbers(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n != 0) {
            nums.add(n % 10);
            n /= 10;
        }
        int res = 0;
        int len = nums.size();
        // 计算位数在[1, len - 1]的数量
        for (int i = 1; i < len; i++) {
            int t = 9;
            // 9 * A(9, i - 1)
            // 第一位 9
            // 第二位 9 * 9
            // 第三位 9 * 9 * 8
            for (int j = 0, k = 9; j < i - 1; j++, k--) {
                t *= k;
            }
            res += t;
        }

        // 反转nums
        int[] arr = new int[len];
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            arr[i] = nums.get(j);
        }
        // 表示某个数字是否出现过
        boolean[] app = new boolean[10];
        for (int i = 0; i < len; i++) {
            // 第1位不能是0
            int from = (i == 0 ? 1 : 0);
            for (int j = from; j < arr[i]; j++) {
                // 出现过，则跳过
                if (app[j]) {
                    continue;
                }
                // 计算 A (9 - i, len - i - 1)
                int t = 1;
                for (int k = 0, u = 9 - i; k < len - i - 1; k++, u--) {
                    t *= u;
                }
                res += t;
            }
            // arr[i]已出现过，该分支无需继续计算，跳出
            if (app[arr[i]]) {
                break;
            }
            app[arr[i]] = true;
        }

        Set<Integer> set = new HashSet<>(nums);
        // 判断 n 是否满足条件
        if (len == set.size()) {
            res++;
        }
        return res;
    }
}
