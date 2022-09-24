package contest.leetcode20220918;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfPrefixScoresOfStrings {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int n = words.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = trie.getCnt(words[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfPrefixScoresOfStrings ss = new SumOfPrefixScoresOfStrings();
        String[] words = {"abc","ab","bc","b"};
        System.out.println(Arrays.toString(ss.sumPrefixScores(words)));
    }
}

class Trie {
    private final Trie[] children;
    private boolean isEnd;
    private int cnt;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
        this.cnt = 0;
    }

    public void insert(String s) {
        Trie node = this;
        char[] sc = s.toCharArray();
        for (char c : sc) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Trie();
            }
            node = node.children[i];
            node.cnt++;
        }
        node.isEnd = true;
    }

    public Trie searchPrefix(String s) {
        Trie node = this;
        char[] sc = s.toCharArray();
        for (char c : sc) {
            int i = c - 'a';
            if (node.children[i] == null) {
                return null;
            }
            node = node.children[i];
        }
        return node;
    }

    public boolean startsWith(String s) {
        return searchPrefix(s) != null;
    }

    public int getCnt(String s) {
        int total = 0;
        Trie node = this;
        char[] sc = s.toCharArray();
        for (char c : sc) {
            int i = c - 'a';
            if (node.children[i] == null) {
                break;
            }
            node = node.children[i];
            total += node.cnt;
        }
        return total;
    }
}


