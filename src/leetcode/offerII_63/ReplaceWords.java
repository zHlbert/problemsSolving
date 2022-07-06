package leetcode.offerII_63;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/UhWRSj/
 * https://leetcode.cn/problems/replace-words/
 */
public class ReplaceWords {
    // 字典树
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String dict : dictionary) {
            trie.insert(dict);
        }
        String[] arr = sentence.split(" ");
        int n = arr.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            char[] chars = s.toCharArray();
            StringBuilder prefix = new StringBuilder();
            for (char ch : chars) {
                prefix.append(ch);
                if (trie.search(prefix.toString())) {
                    res[i] = prefix.toString();
                    break;
                }
            }
            res[i] = prefix.toString();
        }
        return String.join(" ", res);
    }

    public String replaceWords1(List<String> dictionary, String sentence) {
        TrieX trieX = new TrieX();
        for (String dict : dictionary) {
            trieX.insert(dict);
        }
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = trieX.shortestPrefix(arr[i]);
        }
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();
//        String[] dictionary = new String[] {"cat","bat","rat"};
        List<String> dictionary = new ArrayList<>(Arrays.asList("cat","bat","rat"));
        String sentence = "the cattle was rattled by the battery";
//        List<String> dictionary = new ArrayList<>(Arrays.asList("a","b","c"));
//        String sentence = "aadsfasf absbs bbab cadsfafs";
        System.out.println(rw.replaceWords1(dictionary, sentence));
    }
}

class Trie {
    private final Trie[] children;
    private boolean isEnd;

    Trie() {
        this.children = new Trie[26];
    }

    public void insert(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie res = searchPrefix(word);
        return res != null && res.isEnd;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }
}

class TrieX {
    private final TrieX[] children;
    String word;

    TrieX() {
        this.children = new TrieX[26];
        word = null;
    }

    public void insert(String word) {
        TrieX node = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieX();
            }
            node = node.children[idx];
        }
        node.word = word;
    }

    public String shortestPrefix(String word) {
        TrieX node = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return word;
            }
            node = node.children[idx];
            if (node.word != null) {
                return node.word;
            }
        }
        return word;
    }
}
