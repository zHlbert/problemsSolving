package leetcode._890;

import java.util.*;

/**
 * https://leetcode.cn/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int m = pattern.length();
        char[] pArr = pattern.toCharArray();
        Map<Character, Character> pwMap = new HashMap<>();
        Map<Character, Character> wpMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            char[] wordArr = word.toCharArray();
            boolean match = true;
            for (int i = 0; i < m; i++) {
                if (!pwMap.containsKey(pArr[i]) && !wpMap.containsKey(wordArr[i])) {
                    pwMap.put(pArr[i], wordArr[i]);
                    wpMap.put(wordArr[i], pArr[i]);
                } else if (!pwMap.containsKey(pArr[i]) || !wpMap.containsKey(wordArr[i])
                            || pwMap.get(pArr[i]) != wordArr[i]
                            || wpMap.get(wordArr[i]) != pArr[i]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                res.add(word);
            }
            pwMap.clear();
            wpMap.clear();
        }
        return res;
    }

    public List<String> findAndReplacePattern1(String[] words, String pattern) {
        char[] pArr = pattern.toCharArray();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            char[] wordArr = word.toCharArray();
            if (isMatched(wordArr, pArr)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isMatched(char[] w, char[] p) {
        int[] wpMap = new int[130];
        int[] pwMap = new int[130];
        Arrays.fill(wpMap, -1);
        Arrays.fill(pwMap, -1);
        int n = w.length;
        for (int i = 0; i < n; i++) {
            if (pwMap[p[i]] == -1 && wpMap[w[i]] == -1) {
                pwMap[p[i]] = w[i];
                wpMap[w[i]] = p[i];
            } else if (pwMap[p[i]] == -1 || wpMap[w[i]] == -1
                    || pwMap[p[i]] != w[i] || wpMap[w[i]] != p[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAndReplacePattern fr = new FindAndReplacePattern();
        String[] words = new String[] {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(fr.findAndReplacePattern1(words, pattern));
    }
}
