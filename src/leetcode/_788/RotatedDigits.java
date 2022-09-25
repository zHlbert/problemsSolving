package leetcode._788;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/rotated-digits/
 */
public class RotatedDigits {
    static int[] check = {0,0,1,-1,-1,1,1,-1,0,1};
    int[][][] memo = new int[5][2][2];
    int[] digits;

    /**
     * 数位DP
     * @param n
     * @return
     */
    public int rotatedDigits(int n) {
        digits = new int[5];
        int c = 0;
        while (n > 0) {
            digits[c++] = n % 10;
            n /= 10;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(c - 1, 1, 0);
    }

    /**
     * 记忆化搜索
     * @param pos 第几位
     * @param bound 从第 00 位到第 pos−1 位的数是否「贴着」n，记为 bound。
     *              例如当 n=12345，pos=3 时，如果前面的数位是 123，那就表示贴着 n，如果是 122, 121,⋯，那就表示没有贴着 n
     * @param good 1: 至少有[2，5，6，9]中的一个，即为好数 0: 没有[2，5，6，9]中的一个
     * @return
     */
    private int dfs(int pos, int bound, int good) {
        if (pos == -1) {
            return good;
        }
        if (memo[pos][bound][good] != -1) {
            return memo[pos][bound][good];
        }
        int res = 0;
        for (int i = 0; i <= (bound != 0 ? digits[pos] : 9); i++) {
            if (check[i] == -1) {
                continue;
            }
            res += dfs(pos - 1
                    , bound != 0 && i == digits[pos] ? 1 : 0
                    , good != 0 || check[i] == 1 ? 1 : 0);
        }
        return res;
    }
}
