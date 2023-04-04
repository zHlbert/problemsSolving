package leetcode._1627;

public class NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int res = 1;
        int m = Math.min(a, b);
        for (int i = 2; i <= m; i++) {
            if (a % i == 0 && b % i == 0) res++;
        }
        return res;
    }

    public int commonFactors1(int a, int b) {
        int res = 0;
        int c = getGcd(a, b);
        for (int x = 1; x * x <= c; x++)
            if (c % x == 0)
                res += x * x == c ? 1 : 2;
        return res;
    }

    private int getGcd(int a, int b) {
        return b != 0 ? getGcd(b, a % b) : a;
    }
}
