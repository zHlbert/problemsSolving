package leetcode._668;

/**
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 */
public class KthSmallestNumberInMultiplicationTable {
    // 二分查找
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            // 求第几小等价于求有多少数字不超过 x
            int x = (left + right) >> 1;
            // 小于x的个数
            // https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/solution/cheng-fa-biao-zhong-di-kxiao-de-shu-by-l-521a/
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; i++) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
