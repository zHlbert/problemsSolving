package leetcode._1638;

import utils.ArrayUtils;

import java.util.Arrays;

public class CountSubstringsThatDifferByOneCharacter {
    public int countSubstrings(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int res = 0;
        int sn = sc.length;
        for (int i = 0; i < sn; i++) {
            int tn = tc.length;
            for (int j = 0; j < tn; j++) {
                int diff = 0;
                for (int k = 0; i + k < sn && j + k < tn; k++) {
                    if (sc[i + k] != tc[j + k]) diff++;
                    if (diff == 1) res++;
                    else if (diff > 1) break;
                }
            }
        }
        return res;
    }

    /**
     * 动态规划
     * dpl[i][j] 表示 从左侧开始到 s[i] 和 t[j] 的相等字符串长度，不包含 s[i] 及 t[j]
     * dpr[i][j] 表示 从右侧开始到 s[i] 和 t[j] 的相等字符串长度，不包含 s[i] 及 t[j]
     *
     * @param s
     * @param t
     * @return
     */
    public int countSubstrings1(String s, String t) {
        int m = s.length(), n = t.length();
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        int[][] dpl = new int[m][n];
        int[][] dpr = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpl[i][j] = sc[i - 1] == tc[j - 1] ? dpl[i - 1][j - 1] + 1 : 0;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dpr[i][j] = sc[i + 1] == tc[j + 1] ? dpr[i + 1][j + 1] + 1 : 0;
            }
        }

//        ArrayUtils.print2DArray(dpl);
//        System.out.println();
//        ArrayUtils.print2DArray(dpr);

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sc[i] != tc[j]) res += (dpl[i][j] + 1) * (dpr[i][j] + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubstringsThatDifferByOneCharacter cs = new CountSubstringsThatDifferByOneCharacter();
//        System.out.println(cs.countSubstrings1("aba", "baba"));
//        System.out.println(cs.countSubstrings1("ab", "bb"));
        System.out.println(cs.countSubstrings("aabcdabcd", "aabccabcd"));
        System.out.println(cs.countSubstrings1("aabcdabcd", "aabccabcd"));
    }
}
