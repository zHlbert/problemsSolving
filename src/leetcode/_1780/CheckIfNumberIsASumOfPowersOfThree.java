package leetcode._1780;

import java.util.Arrays;

/**
 * 判断一个数字是否可以表示成三的幂的和
 * https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/
 */
public class CheckIfNumberIsASumOfPowersOfThree {
    int c = 0;
    int[] pow3 = new int[20];
    int n;
    public boolean checkPowersOfThree(int n) {
        if (n == 1) {
            return true;
        }
        this.n = n;
        pow3[c++] = 1;
        for (; ; c++) {
            pow3[c] = pow3[c - 1] * 3;
            if (pow3[c] == n) return true;
            if (pow3[c] > n) break;
        }
//        System.out.println(Arrays.toString(pow3) + ", " + c);
        return backtrack(0, 0);
    }

    private boolean backtrack(int start, int sum) {
        if (sum == n) return true;
        if (sum > n) return false;
        for (int i = start; i < c; i++) {
            if (backtrack(i + 1, sum + pow3[i]))
                return true;
        }
        return false;
    }

    /**
     * 我们可以将 n 转换成 3 进制。如果 n 的 3 进制表示中每一位均不为 2，那么答案为 True，否则为 False
     *
     * @param n
     * @return
     */
    public boolean checkPowersOfThree1(int n) {
        while (n > 1) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfNumberIsASumOfPowersOfThree cn = new CheckIfNumberIsASumOfPowersOfThree();
//        int[] ns = {1,2,3,4,5,6,12,91,21};
//        for (int n : ns) {
//            System.out.println(n + ": " + cn.checkPowersOfThree(n));
//        }
        System.out.println(cn.checkPowersOfThree(91));
    }
}
