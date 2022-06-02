package leetcode._829;

/**
 * Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/consecutive-numbers-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/consecutive-numbers-sum/
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int count = 1;
        // 设 连续数中第一个数为 x, 连续数有n个，则有 （x + 0.5 * (k - 1)） * k = n
        // x = (2 * n - k ^ 2 + 2 * k) / (2 * k)
        // x 为正整数时 符合条件
        for (int k = 2; k * k <= 2 * n; k++) {
            int denominator = (2 * n) - k * k + k;
            int numerator = 2 * k;
            if (denominator >= numerator && (denominator % numerator == 0)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ConsecutiveNumbersSum cns = new ConsecutiveNumbersSum();
        for (int i = 1; i < 16; i++) {
            System.out.println(i + " : " + cns.consecutiveNumbersSum(i));
        }
    }
}
