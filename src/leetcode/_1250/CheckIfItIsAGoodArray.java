package leetcode._1250;

public class CheckIfItIsAGoodArray {
    /**
     * 「裴蜀定理」的内容为：对于不全为零的任意整数
     * a 和 b，记 g = gcd(a,b)，其中 gcd(a,b) 为 a * b 的最小公约数，
     * 则对于任意整数 x 和 y 都满足 a×x+b×y 是 g 的倍数
     * 特别地，存在整数 x 和 y 满足 a×x+b×y=g
     * @param nums
     * @return
     */
    public boolean isGoodArray(int[] nums) {
        int g = 0;
        for (int num : nums) {
            g = gcd(num, g);
            if (g == 1)
                break;
        }
        return g == 1;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
