package leetcode._667;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/beautiful-arrangement-ii/
 */
public class BeautifulArrangementII {
    /**
     * 构造
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        // 前 n - k 个 递增1
        for (int i = 0; i < n - k; i++) {
            res[i] = i + 1;
        }

        // [n - k - 1, n - 1] 位 依次为 n - k, n, n - k + 1, n - 1, ...
        for (int i = n - k, d = k, op = 1; i < n; i++, d--, op = -op) {
            res[i] = res[i - 1] + d * op;
        }
        return res;
    }

    public static void main(String[] args) {
        BeautifulArrangementII ba = new BeautifulArrangementII();
//        System.out.println(Arrays.toString(ba.constructArray(3, 2)));
//        System.out.println(Arrays.toString(ba.constructArray(3, 1)));
//        System.out.println(Arrays.toString(ba.constructArray(4, 2)));
        System.out.println(Arrays.toString(ba.constructArray(5, 4)));
    }
}
