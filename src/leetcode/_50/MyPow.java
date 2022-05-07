package leetcode._50;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */
public class MyPow {
    public double myPowIntern(double x, long n) {
        double ans = 1.0;
        double xTemp = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= xTemp;
            }
            xTemp *= xTemp;
            n /= 2;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? myPowIntern(x, N) : 1.0 / myPowIntern(x, -N);
    }

    public static void main(String[] args) {
        MyPow m = new MyPow();
        System.out.println(m.myPow(2.0, 3));
        System.out.println(m.myPow(2.0, -3));
    }
}
