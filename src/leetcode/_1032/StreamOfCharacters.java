package leetcode._1032;

import java.util.Set;
import java.util.TreeMap;

public class StreamOfCharacters {
//    public static void main(String[] args) {
////        double s1 = -14445004863.75;
////        double s2 = -14772270530.98;
////        double df = s2 - s1;
////        System.out.println(df);
//        String dfs = "32726566723";
////        String dfs = "726566723";
////        System.out.println(dfs);
//        int di = Integer.parseInt(dfs);
//        System.out.println(di);
////        System.out.println(-Integer.MAX_VALUE);
//    }
}

class Trie {

    Trie[] children = new Trie[26];
    boolean isEnd = false;

    public void insert(String w) {
        Trie node = this;
        for (int i = w.length() - 1; i >= 0; i--) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean query(StringBuilder sb) {
        Trie node = this;
        for (int i = sb.length() - 1, j = 0; i >= 0 && j < 201; i--, j++) {
            int idx = sb.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
            if (node.isEnd) return true;
        }
        return false;
    }
}

class StreamChecker {

    private StringBuilder sb = new StringBuilder();
    private Trie trie = new Trie();

    public StreamChecker(String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return trie.query(sb);
    }
}
