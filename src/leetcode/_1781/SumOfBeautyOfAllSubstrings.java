package leetcode._1781;

import utils.ArrayUtils;

/**
 * 所有子字符串美丽值之和
 * https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/
 */
public class SumOfBeautyOfAllSubstrings {
    /**
     * 前缀和
     * @param s
     * @return
     */
    public int beautySum(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;

        int[][] prefix = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                prefix[i + 1][j] = prefix[i][j];
            }
            int dv = sc[i] - 'a';
            prefix[i + 1][dv] = prefix[i][dv] + 1;
        }

//        ArrayUtils.print2DArray(prefix);

        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                int[] l = prefix[i], r = prefix[j + 1];
                int mx = 0, mn = 500;
                for (int k = 0; k < 26; k++) {
                    int freq = r[k] - l[k];
                    if (freq > 0) {
                        mx = Math.max(mx, freq);
                        mn = Math.min(mn, freq);
                    }
                }
//                System.out.println(i + ", " + j + ": " + mx + ", " + mn);
                res += mx - mn;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfBeautyOfAllSubstrings sb = new SumOfBeautyOfAllSubstrings();
        System.out.println(sb.beautySum("aabcb"));
        System.out.println(sb.beautySum("aabcbaa"));
    }
}
