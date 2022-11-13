package leetcode._805;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/split-array-with-same-average/
 *
 * 数组的均值分割
 */
public class SplitArrayWithSameAverage {
    /**
     * 折半搜索
     * @param nums
     * @return
     */
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, sum = 0, m = n / 2;
        if (n == 1) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }
        Set<Integer> left = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int tot = 0;
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    tot += nums[j];
                }
            }
            if (tot == 0) { // 全选左边
                return true;
            }
            left.add(tot);
        }

        int rsum = 0;
        for (int i = m; i < n; i++) {
            rsum += nums[i];
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int tot = 0;
            for (int j = m; j < n; j++) {
                if (((i >> (j - m)) & 1) == 1) {
                    tot += nums[j];
                }
            }

            // 右边不能全部用上
            if (tot == 0 || tot != rsum && left.contains(-tot)) {
                return true;
            }
        }
        return false;
    }

    // TODO: 2022/11/13 动态规划
}
