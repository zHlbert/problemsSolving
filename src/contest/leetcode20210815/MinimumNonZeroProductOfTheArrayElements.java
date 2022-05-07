package contest.leetcode20210815;

/**
 * You are given a positive integer p. Consider an array nums (1-indexed) that consists of the integers in the inclusive range [1, 2p - 1] in their binary representations. You are allowed to do the following operation any number of times:
 *
 * Choose two elements x and y from nums.
 * Choose a bit in x and swap it with its corresponding bit in y. Corresponding bit refers to the bit that is in the same position in the other integer.
 * For example, if x = 1101 and y = 0011, after swapping the 2nd bit from the right, we have x = 1111 and y = 0001.
 *
 * Find the minimum non-zero product of nums after performing the above operation any number of times. Return this product modulo 109 + 7.
 *
 * Note: The answer should be the minimum product before the modulo operation is done.
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-non-zero-product-of-the-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumNonZeroProductOfTheArrayElements {
    int mod = 1000000007;
    public int minNonZeroProduct(int p) {
        long a = (1L << p) - 1L;
        long x = a - 1L;
        long n = x / 2L;
        long pow = pow(x % mod, n) % mod;
        return (int) ((a % mod) * (pow % mod) % mod);
    }

    private long pow(long x, long n) {
        long ans = 1;
        long xTemp = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * xTemp;
                ans %= mod;
            }
            xTemp *= xTemp;
            xTemp %= mod;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumNonZeroProductOfTheArrayElements m = new MinimumNonZeroProductOfTheArrayElements();
//        System.out.println(m.minNonZeroProduct(1));
//        System.out.println(m.minNonZeroProduct(2));
//        System.out.println(m.minNonZeroProduct(3));
//        System.out.println(m.minNonZeroProduct(4));
//        System.out.println(m.minNonZeroProduct(5));
//        System.out.println(m.minNonZeroProduct(6));
//        System.out.println(m.minNonZeroProduct(7));
//        System.out.println(m.minNonZeroProduct(8));
//        System.out.println(m.minNonZeroProduct(9));
//        System.out.println(m.minNonZeroProduct(10));
        System.out.println(m.minNonZeroProduct(32));
//        System.out.println(m.pow(2, 4));
    }
}
