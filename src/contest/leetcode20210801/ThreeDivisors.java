package contest.leetcode20210801;

/**
 * Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
 *
 * An integer m is a divisor of n if there exists an integer k such that n = k * m.
 */
public class ThreeDivisors {
    public boolean isThree(int n) {
        if (n <= 2) {
            return false;
        }
        boolean hasThree = false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                if (hasThree) {
                    return false;
                }
                hasThree = true;
            }
        }
        return hasThree;
    }

    public static void main(String[] args) {
        ThreeDivisors t = new ThreeDivisors();
        for (int i = 1; i < 13; i++) {
            System.out.println(i + ", " + t.isThree(i));
        }
    }
}
