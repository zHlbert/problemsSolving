package contest.leetcode20220508;

import utils.ArrayUtils;

/**
 * https://leetcode-cn.com/contest/weekly-contest-292/problems/count-number-of-texts/
 */
public class CountNumberOfTexts {
    long res = 0;
    int mod = 1000000007;
    char[][] num2Char = new char[][] {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
//    public int countTexts(String pressedKeys) {
////        backtracking(pressedKeys);
//        return (int) res;
//    }

//    private int backtracking(String pressedKeys) {
//        int len = pressedKeys.length();
//        if (len == 0 || len == 1) {
//            return len;
//        }
//        char c0 = pressedKeys.charAt(0);
//        char c1 = pressedKeys.charAt(1);
//        boolean eq01 = (c0 == c1);
//        if (len == 2) {
//            return eq01 ? 2 : 1;
//        }
//        char c2 = pressedKeys.charAt(2);
//        boolean eq12 = (c1 == c2);
//        if (len == 3) {
//            if (eq01 && eq12) {
//                return 4;
//            }
//            if (!eq01 && !eq12) {
//                return 1;
//            }
//            return 2;
//        }
//        char c3 = pressedKeys.charAt(3);
//        boolean eq23 = (c2 == c3);
//        if (len == 4) {
////            if ()
//        }
//        return 0;
//    }

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        char[] chars = pressedKeys.toCharArray();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i > 1 && chars[i - 1] == chars[i - 2]) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
                if (i > 2 && chars[i - 2] == chars[i - 3]) {
                    dp[i] = (dp[i] + dp[i - 3]) % mod;
                    if (i > 3 && chars[i - 3] == chars[i - 4] && (chars[i - 1] == '7' || chars[i - 1] == '9')) {
                        dp[i] = (dp[i] + dp[i - 4]) % mod;
                    }

                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CountNumberOfTexts cnt = new CountNumberOfTexts();
        String keys = "22233";
        System.out.println(cnt.countTexts(keys));
    }
}
