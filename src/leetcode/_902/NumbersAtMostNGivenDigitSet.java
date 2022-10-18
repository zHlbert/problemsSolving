package leetcode._902;

public class NumbersAtMostNGivenDigitSet {
//    public int atMostNGivenDigitSet(String[] digits, int n) {
//        int[] ns = new int[10];
//        int c = 0;
//        while (n != 0) {
//            ns[c++] = n % 10;
//            n /= 10;
//        }
//        for (int i = 0, j = c - 1; i < j; i++, j--) {
//            int t = ns[i];
//            ns[i] = ns[j];
//            ns[j] = t;
//        }
//        int res = 0, cnt = digits.length;
//
//        if (c > 1) {
//            int z = 1;
//            for (int j = 0; j < c - 1; j++) {
//                z *= cnt;
//            }
//            res += (cnt == 1 ? 1 : cnt * (z - 1) / (cnt - 1));
//        }
//
//        for (int i = 0; i < c; i++) {
//            int mu = find(ns[i], digits);
//            int z = 1;
//            for (int j = 0; j < c - i - 1; j++) {
//                z *= cnt;
//            }
//            if (i < c - 1) {
//                res += mu * (cnt == 1 ? 1 : cnt * (z - 1) / (cnt - 1));
//            } else {
//                res += mu;
//                if (mu < c && ns[i] == Integer.parseInt(digits[mu])) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }

    private int find(int d, String[] digits) {
        int l = 0, r = digits.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            int num = Integer.parseInt(digits[mid]);
            if (num < d) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int ll = Integer.parseInt(digits[l]) < d ? l : -1;
        return ll + 1;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int m = digits.length;
        int[] dg = new int[m];
        for (int i = 0; i < m; i++) {
            dg[i] = Integer.parseInt(digits[i]);
        }
        return dp(dg, n);
    }

    private int dp(int[] dg, int x) {
        int c = 0;
        int[] ns = new int[12];
        while (x != 0) {
            ns[c++] = x % 10;
            x /= 10;
        }

        int res = 0, m = dg.length;
        // 小于 x 的个数
        for (int i = 1, last = 1; i < c; i++) {
            int cur = last * m;
            res += cur;
            last = cur;
        }

        for (int i = c - 1, p = 1; i >= 0; i--, p++) {
            int cur = ns[i];
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (dg[mid] <= cur) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (dg[l] > cur) {
                break;
            } else if (dg[l] < cur) {
                res += (l + 1) * Math.pow(m, (c - p));
                break;
            } else {
                res += l * Math.pow(m, (c - p));
                res += (i == 0 ? 1 : 0);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NumbersAtMostNGivenDigitSet nm = new NumbersAtMostNGivenDigitSet();
//        String[] digits = new String[] {"1","3","5","7"};
//        int n = 100;
//        String[] digits = new String[] {"1","4","9"};
//        int n = 1000000000;
//        String[] digits = new String[] {"7"};
//        int n = 8;
        String[] digits = new String[] {"3","5"};
        int n = 4;
//        String[] digits = new String[] {"9"};
//        int n = 55;
        System.out.println(nm.atMostNGivenDigitSet(digits, n));
    }
}
