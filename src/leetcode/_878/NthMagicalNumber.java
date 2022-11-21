package leetcode._878;

/**
 * 第 N 个神奇数字
 * https://leetcode.cn/problems/nth-magical-number/
 *
 */
public class NthMagicalNumber {
    int mod = (int) (1e9 + 7);
    // 二分
    public int nthMagicalNumber(int n, int a, int b) {
        int c = a * b / gcd(a, b);
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        while (l < r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) (l % mod);
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    // TODO: 2022/11/21 找规律
}
