package leetcode._745;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/prefix-and-suffix-search/
 */
public class PrefixAndSuffixSearch {
    public static void main(String[] args) {
        String[] words = new String[] {"apple"};
        WordFilter wf = new WordFilter(words);
        System.out.println(wf.f("a", "le"));
    }
}

/**
 * https://leetcode.cn/problems/prefix-and-suffix-search/solution/qian-zhui-he-hou-zhui-sou-suo-by-leetcod-i3ec/
 */
class WordFilter {
    Trie trie;

    public WordFilter(String[] words) {
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] wc = word.toCharArray();
            Trie cur = trie;
            int m = word.length();
            for (int j = 0; j < m; j++) {
                Trie tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = String.valueOf(wc[k]) + '#';
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight = i;
                }
                tmp = cur;
                for (int k = j; k < m; k++) {
                    String key = "#" + wc[m - k - 1];
                    if (!tmp.children.containsKey(key)) {
                        tmp.children.put(key, new Trie());
                    }
                    tmp = tmp.children.get(key);
                    tmp.weight = i;
                }
                String key = String.valueOf(wc[j]) + wc[m - j - 1];
                if (!cur.children.containsKey(key)) {
                    cur.children.put(key, new Trie());
                }
                cur = cur.children.get(key);
                cur.weight = i;
            }
        }
    }

    public int f(String pref, String suff) {
        Trie cur = trie;
        int m = Math.max(pref.length(), suff.length());
        char[] pc = pref.toCharArray();
        char[] sc = suff.toCharArray();
        for (int i = 0; i < m; i++) {
            char c1 = i < pc.length ? pc[i] : '#';
            char c2 = i < sc.length ? sc[sc.length - i - 1] : '#';
            String key = String.valueOf(c1) + c2;
            if (!cur.children.containsKey(key)) {
                return -1;
            }
            cur = cur.children.get(key);
        }
        return cur.weight;
    }
}

class Trie {
    Map<String, Trie> children;
//    Map<String, Integer> weight;
    int weight;

    public Trie() {
        children = new HashMap<>();
//        weight = new HashMap<>();
        weight = 0;
    }
}
