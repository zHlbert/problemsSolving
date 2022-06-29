package leetcode._1175;

/**
 * https://leetcode.cn/problems/prime-arrangements/
 */
public class PrimeArrangements {
    int mod = (int) (1e9 + 7);
    public int numPrimeArrangements(int n) {
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i + 1)) {
                m++;
            }
        }
        long res = 1;
        for (int i = 0; i < m; i++) {
            res = (res * (i + 1)) % mod;
        }

        for (int i = 0; i < n - m; i++) {
            res = (res * (i + 1)) % mod;
        }
        return (int) res;
    }

    public boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            int d = x / i;
            if (d * i == x) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeArrangements pa = new PrimeArrangements();
        System.out.println(pa.numPrimeArrangements(5));
        System.out.println(pa.numPrimeArrangements(100));
    }
}
