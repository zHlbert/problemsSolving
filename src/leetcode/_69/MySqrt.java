package leetcode._69;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int n = 0;
        int tmp = x;
        while (tmp > 1) {
            tmp /= 2;
            n++;
        }
        int sqrtN = n / 2;
        int lo = 2 << (sqrtN - 1);
        int hi = 2 << sqrtN;
        int mid = (lo + hi) >> 1;
        while (lo < hi) {
            if (square(mid) == x || (square(mid) < x && square(mid + 1) > x)) {
                break;
            }
            if (square(mid) < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            mid = (lo + hi) >> 1;
        }
        return mid;
    }

    private long square(int x) {
        return (long) x * x;
    }

    public static void main(String[] args) {
        MySqrt m = new MySqrt();
//        System.out.println(m.mySqrt(0));
//        System.out.println(m.mySqrt(1));
//        System.out.println(m.mySqrt(2));
//        System.out.println(m.mySqrt(3));
//        System.out.println(m.mySqrt(4));
//        System.out.println(m.mySqrt(5));
//        System.out.println(m.mySqrt(8));
//        System.out.println(m.mySqrt(9));
//        System.out.println(m.mySqrt(75));
//        System.out.println(m.mySqrt(442));
//        System.out.println(m.mySqrt(1000));
//        System.out.println(m.mySqrt(5000));
//        System.out.println(m.mySqrt(10000));
//        System.out.println(m.mySqrt(10001));
//        System.out.println(m.mySqrt(224234214));
        System.out.println(m.mySqrt(1234252345));
//        1234252345

    }
}
