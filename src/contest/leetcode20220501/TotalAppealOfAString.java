package contest.leetcode20220501;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-291/problems/total-appeal-of-a-string/
 */
public class TotalAppealOfAString {
//    public long appealSum(String s) {
//        char[] chars = s.toCharArray();
//        int n = chars.length;
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
//        Set<Character> charSet = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            charSet.add(chars[i]);
//            dp[0][i] = charSet.size();
//        }
//        charSet.clear();
//        for (int i = n - 1; i >= 0; i--) {
//            charSet.add(chars[i]);
//            dp[i][0] = charSet.size();
//        }
//        for (int i = 1; i < n - 2; i++) {
//            for (int j = i + 1; j < n - 1; j++) {
//                if (dp[i][0] != dp[i + 1][0] || dp[0][j - 1] != dp[0][j]) {
//                    dp[i][j] = dp[i][j - 1] + 1;
//                } else {
//                    dp[i][j] = dp[i][j - 1];
//                }
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                sum += dp[i][j];
//            }
//        }
//        return sum;
//    }

    public long appealSum(String s) {
        char[] chars = s.toCharArray();
        // 记录上次出现的下标
        int[] last = new int[26];
        Arrays.fill(last, -1);
        long sumG = 0, res = 0;
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            // 如果 s[i] 之前没有遇到过，那么这些子串的引力值都会增加 1，
            // 这些子串的引力值之和会增加 i，再加上 1，即 s[i] 单独组成的子串的引力值；(i - (-1))
            //
            // 如果 s[i] 之前遇到过，设其上次出现的下标为 j，那么向子串
            // s[0..i-1], s[1..i-1], s[2..i-1], ... ,s[j..i-1] 的末尾添加 s[i] 后，
            // 这些子串的引力值是不会变化的，因为 s[i] 已经在 s[j] 处出现过了；
            // 而子串 s[j+1..i-1], s[j+2..i-1],...,s[i-1..i-1] 由于不包含字符 s[i]，
            // 这些子串的引力值都会增加 1，因此有 i-j-1 个子串的引力值会增加 1，
            // 这些子串的引力值之和会增加 i-j-1，再加上 1，即 s[i] 单独组成的子串的引力值。

            // sumG 以 s[i] 结尾的子串的引力值之和
            sumG += i - last[idx];
            res += sumG;
            last[idx] = i;
        }
        return res;
    }
}
