package leetcode._792;

import contest.leetcode20220625.NumberOfDistinctRollSequences;

import java.util.ArrayList;
import java.util.List;

/**
 * 匹配子序列的单词数
 * https://leetcode.cn/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {
    /**
     * 二分
     * @param s
     * @param words
     * @return
     */
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        char[] sc = s.toCharArray();
        int ns = sc.length;
        for (int i = 0; i < ns; i++) {
            pos[sc[i] - 'a'].add(i);
        }

        int res = words.length;
        for (String word : words) {
            if (word.length() > ns) {
                res--;
                continue;
            }
            int p = -1;
            for (char c : word.toCharArray()) {
                ArrayList<Integer> po = pos[c - 'a'];
                int sz = po.size();
//                System.out.println(word + "," + c + "," + po + "," + p);
                if (po.isEmpty() || po.get(sz - 1) <= p) {
                    res--;
                    break;
                }
                p = binarySearch(po, p);
            }
        }
        return res;
    }

    private int binarySearch(ArrayList<Integer> po, int p) {
        int l = 0, r = po.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (po.get(mid) > p) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
//        System.out.println(po.get(l) + ":" + p);
        return po.get(l);
    }

    // TODO: 2022/11/17 多指针

    public static void main(String[] args) {
        NumberOfMatchingSubsequences nm = new NumberOfMatchingSubsequences();
        String s = "abcde";
        String[] words = new String[] {"a","bb","acd","ace"};
        System.out.println(nm.numMatchingSubseq(s, words));
    }
}
