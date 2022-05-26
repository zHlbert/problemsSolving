package leetcode.interview1711;

import java.util.*;

/**
 * https://leetcode.cn/problems/find-closest-lcci/
 */
public class FindClosestLCCI {
    public int findClosest(String[] words, String word1, String word2) {
        int len = words.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (words[i].equals(word1)) {
                list1.add(i);
            }
            if (words[i].equals(word2)) {
                list2.add(i);
            }
        }

        if (list1.isEmpty() || list2.isEmpty()) {
            return -1;
        }
        if (word1.equals(word2)) {
            return 0;
        }
        int m = list1.size(), n = list2.size();
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int idx1 = list1.get(i);
            int idx2 = list2.get(j);
            res = Math.min(res, Math.abs(idx1 - idx2));
            if (idx1 < idx2) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    public int findClosestDirect(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1, n = words.length, res = n + 1;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                i1 = i;
                if (i2 == -1) {
                    continue;
                }
                res = Math.min(res, Math.abs(i1 - i2));
                if (res == 1) {
                    return res;
                }
            } else if (word.equals(word2)) {
                i2 = i;
                if (i1 == -1) {
                    continue;
                }
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindClosestLCCI fc = new FindClosestLCCI();
        String[] words = new String[] {"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a";
        String word2 = "student";
        System.out.println(fc.findClosest(words, word1, word2));
    }
}
