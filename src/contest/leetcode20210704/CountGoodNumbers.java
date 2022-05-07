package contest.leetcode20210704;

import java.util.Arrays;

/**
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
 *
 * For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
 * Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
 *
 * A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
 */
public class CountGoodNumbers {
    public int countGoodNumbers(long n) {
        long num = (long) (Math.pow(10.0, 9) + 7);
        long res = 1;
        for (long i = 0; i < n; i++) {
            if (res > num)
                res = res % num;
            if (i % 2 == 0) {
                res *= 5;
            } else {
                res = res << 2;
            }
        }
        return (int) (res % num);
    }

    static int mod = 1000000007;

    public int countGoodNumbers1(long n) {
        long od = n >> 1;
        long ev = n - od;
        return pow(4, od) * pow(5, ev) % mod;
    }

    private int pow(long p, long e) {
        if (e == 0) {
            return 1;
        }
        if (e % 2 == 0) {
            return pow(p * p % mod, e / 2);
        }
        return (int) (pow(p, e - 1) * p % mod);
    }

    public int countGoodNumbers2(long n) {
        long od = n >> 1;
        long ev = n - od;
        return (int) ((long) fastPow(4, od) * fastPow(5, ev) % mod);
    }

    private int fastPow(int x, long e) {
        int ret = 1, mul = x;
        while (e > 0) {
            if (e % 2 == 1) {
                ret = (int) ((long) ret * mul % mod);
            }
            mul = (int) ((long) mul * mul % mod);
            e = e/2;
        }
        return ret;
    }

    public static void main(String[] args) {
        CountGoodNumbers c = new CountGoodNumbers();
//        System.out.println(c.countGoodNumbers(1));
//        System.out.println(c.countGoodNumbers(4));
        System.out.println(c.countGoodNumbers2(50));
    }
}
