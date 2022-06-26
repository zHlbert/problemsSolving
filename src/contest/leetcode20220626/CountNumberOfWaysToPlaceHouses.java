package contest.leetcode20220626;

public class CountNumberOfWaysToPlaceHouses {
    public int countHousePlacements(int n) {
        if (n == 1) {
            return 4;
        }
        if (n == 2) {
            return 9;
        }
        long mod = 10000 * 100000 + 7;
        long[] base = new long[n + 1];
        base[0] = 1;
        base[1] = 2;
        for (int i = 2; i <= n; i++) {
            base[i] = (base[i - 1] + base[i - 2]) % mod;
        }
        return (int) ((base[n] * base[n]) % mod);
    }

    public static void main(String[] args) {
        CountNumberOfWaysToPlaceHouses cn = new CountNumberOfWaysToPlaceHouses();
//        System.out.println(cn.countHousePlacements(3));
//        System.out.println(cn.countHousePlacements(4));
        System.out.println(cn.countHousePlacements(1000));
    }
}
