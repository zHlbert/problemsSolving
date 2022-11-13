package contest.leetcode20221113;

import leetcode._1235.MaximumProfitInJobScheduling;

public class MaximumNumberOfNonoverlappingPalindromeSubstrings {
//    public int maxPalindromes(String s, int k) {
//        char[] sc = s.toCharArray();
//        int n = sc.length, ml = 0;
//        int res = 0;
//        int i = 0;
//        while (i < n - k) {
//            boolean palin = true;
//            for (int l = i, r = i + k - 1; l < r && r < n; l++, r--) {
//                if (sc[l] != sc[r]) {
//                    palin = false;
//                    break;
//                }
//            }
//            if (palin) {
//                res++;
//                i = k;
//                continue;
//            }
//            palin = true;
//            for (int l = i, r = i + k; l < r && r < n; l++, r--) {
//                if (sc[l] != sc[r]) {
//                    palin = false;
//                    break;
//                }
//            }
//            if (palin) {
//                res++;
//                i = k + 1;
//            } else {
//                i = i + 1;
//            }
//        }
//        return res;
//    }

    /**
     * 动态规划
     * @param s
     * @param k
     * @return
     */
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] sc = s.toCharArray();
        boolean[][] g = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (sc[i] == sc[j] && (j - i <= 1 || g[i + 1][j - 1])) {
                    g[i][j] = true;
                }
            }
        }
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            for (int j = i - k; j >= 0; j--) {
                if (g[j][i - 1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        MaximumNumberOfNonoverlappingPalindromeSubstrings mn = new MaximumNumberOfNonoverlappingPalindromeSubstrings();
        System.out.println(mn.maxPalindromes("fttfjofpnpfydwdwdnns", 2));
    }
}
