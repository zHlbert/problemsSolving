package leetcode._793;

public class PreimageSizeOfFactorialZeroesFunction {
    /**
     * https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/solution/jie-cheng-han-shu-hou-k-ge-ling-by-leetc-n6vj/
     * @param k
     * @return
     */
    public int preimageSizeFZF(int k) {
        return (int) (cntForTrailingZeros(k + 1) - cntForTrailingZeros(k));
    }

    /**
     * 结尾0的数量小于等于k个的阶乘 个数
     * 二分
     * @param k
     * @return
     */
    private long cntForTrailingZeros(int k) {
        long l = 0;
        long r = 5L * k;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (zeta(mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public long zeta(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        PreimageSizeOfFactorialZeroesFunction ps = new PreimageSizeOfFactorialZeroesFunction();
        System.out.println(ps.preimageSizeFZF(0));
        System.out.println(ps.preimageSizeFZF(1));
        System.out.println(ps.preimageSizeFZF(2));
        System.out.println(ps.preimageSizeFZF(3));
        System.out.println(ps.preimageSizeFZF(4));
        System.out.println(ps.preimageSizeFZF(5));
    }
}
