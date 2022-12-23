package leetcode._1754;

import java.util.Arrays;

/**
 * 构造字典序最大的合并字符串
 * https://leetcode.cn/problems/largest-merge-of-two-strings/
 */
public class LargestMergeOfTwoStrings {
//    public String largestMerge(String word1, String word2) {
//        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
//        int n1 = w1.length, n2 = w2.length;
//        char[] res = new char[n1 + n2];
//        int i = 0, j = 0, k = 0;
//        while (i < n1 && j < n2) {
//            if (w1[i] != w2[j]) {
//                if (w1[i] > w2[j]) res[k++] = w1[i++];
//                else res[k++] = w2[j++];
//            } else {
//                int p = i, q = j;
//                while (p < n1 && q < n2 && w1[p] == w2[q] && w1[p] >= w1[i]) {
//                    res[k++] = w1[p];
//                    p++;
//                    q++;
//                }
//                if (p == n1) {
//                    j = q;
//                } else if (q == n2) {
//                    i = p;
//                } else if (w1[p] == w2[q] && w1[p] < w1[i]) {
//                    i = p;
//                    while (j < q) res[k++] = w2[j++];
//                } else {
//                    if (w1[p] > w2[q]) {
//                        res[k++] = w1[p];
//                        i = p + 1;
//                    } else {
//                        res[k++] = w2[q];
//                        j = q + 1;
//                    }
//                }
//            }
//            System.out.println(Arrays.toString(res));
//            System.out.println(i + ", " + j);
//        }
//
//        while (i < n1) res[k++] = w1[i++];
//        while (j < n2) res[k++] = w2[j++];
//
//        return new String(res);
//    }

    public String largestMerge(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 0; i < word1.length() || j < word2.length();) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                res.append(word1.charAt(i++));
            } else {
                res.append(word2.charAt(j++));
            }
        }
        return res.toString();
    }

    // TODO: 2022/12/24 后缀数组

    public static void main(String[] args) {
        LargestMergeOfTwoStrings lm = new LargestMergeOfTwoStrings();
//        String word1 = "cabaa";
//        String word2 = "bcaaa";
//        String word1 = "abcabc";
//        String word2 = "abdcaba";
        String word1 = "uuurruuuruuuuuuuuruuuuu";
        String word2 = "urrrurrrrrrrruurrrurrrurrrrruu";
//        String word1 = "nngnnnbnttnngsnnntnbgnnnn";
//        String word2 = "nnnnnnnnnnnnnntn";
        System.out.println(lm.largestMerge(word1, word2));
    }
}
