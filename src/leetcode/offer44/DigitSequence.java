package leetcode.offer44;

/**
 * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DigitSequence {
    public int findNthDigit(int n) {
        // d 位数，cnt 当前位数有多少个数
        int d = 1, cnt = 9;
        while (n > (long) d * cnt) {
            n -= d * cnt;
            d++;
            cnt *= 10;
        }
        int index = n - 1, start = 1;
        for (int i = 0; i < d - 1; i++) {
            start *= 10;
        }
        // 所在数
        int num = start + index / d;
        int[] digits = new int[d];
        int i = 0;
        while (num > 0) {
            digits[i++] = num % 10;
            num /= 10;
        }
        return digits[d - 1 - index % d];
    }

    public static void main(String[] args) {
        DigitSequence ds = new DigitSequence();
        System.out.println(ds.findNthDigit(3));
        System.out.println(ds.findNthDigit(10));
        System.out.println(ds.findNthDigit(11));
        System.out.println(ds.findNthDigit(12));
        System.out.println(ds.findNthDigit(13));
        System.out.println(ds.findNthDigit(14));
        System.out.println(ds.findNthDigit(15));
        System.out.println(ds.findNthDigit(1000000000));
    }
}
