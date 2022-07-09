package leetcode._676;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/implement-magic-dictionary/
 */
public class ImplementMagicDictionary {
    public static void main(String[] args) {
        MagicDictionary3 md = new MagicDictionary3();
        md.buildDict(new String[] {"hello", "leetcode"});
        String[] words = new String[] {"hello", "hhllo", "hell", "leetcoded"};
        for (int i = 0; i < words.length; i++) {
            System.out.println(md.search(words[i]));
        }
    }

}

class MagicDictionary {

    Map<Integer, Set<String>> lenWordDict;
    public MagicDictionary() {
        lenWordDict = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int len = s.length();
            Set<String> wordSet = lenWordDict.getOrDefault(len, new HashSet<>());
            wordSet.add(s);
            lenWordDict.put(len, wordSet);
        }
    }

    public boolean search(String searchWord) {
        int sl = searchWord.length();
        if (!lenWordDict.containsKey(sl)) {
            return false;
        }
        Set<String> set = lenWordDict.get(sl);
        char[] chars = searchWord.toCharArray();
        for (int i = 0; i < sl; i++) {
            char c = chars[i];
            for (int j = 0; j < 26; j++) {
                char r = (char) ('a' + j);
                if (r != c) {
                    chars[i] = r;
                    if (set.contains(new String(chars))) {
                        return true;
                    }
                }
            }
            chars[i] = c;
        }
        return false;
    }
}

class MagicDictionary1 {

    Map<Integer, Set<String>> lenWordDict;
    public MagicDictionary1() {
        lenWordDict = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        StringBuilder sb;
        for (String s : dictionary) {
            sb = new StringBuilder(s);
            int len = s.length();
            Set<String> set = lenWordDict.getOrDefault(len, new HashSet<>());
            for (int i = 0; i < s.length(); i++) {
                char c = sb.charAt(i);
                for (int j = 0; j < 26; j++) {
                    char r = (char) ('a' + j);
                    if (c != r) {
                        sb.setCharAt(i, r);
                        set.add(sb.toString());
                    }
                }
                sb.setCharAt(i, c);
            }
            lenWordDict.put(len, set);
        }
    }

    public boolean search(String searchWord) {
        int length = searchWord.length();
        if (!lenWordDict.containsKey(length)) {
            return false;
        }
        Set<String> set = lenWordDict.get(length);
        return set.contains(searchWord);
    }
}

class MagicDictionary2 {

    String[] dict;

    /** Initialize your data structure here. */
    public MagicDictionary2() {

    }

    public void buildDict(String[] dictionary) {
        dict = dictionary;
    }

    public boolean search(String searchWord) {
        int sl = searchWord.length();
        char[] sArr = searchWord.toCharArray();
        for (String d : dict) {
            if (d.length() != sl) {
                continue;
            }
            char[] dArr = d.toCharArray();
            int diff = 0;
            for (int i = 0; i < sl; i++) {
                if (sArr[i] != dArr[i]) {
                    diff++;
                }
                if (diff > 1) {
                    break;
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
}

// 字典树
class MagicDictionary3 {

    Trie root;

    /** Initialize your data structure here. */
    public MagicDictionary3() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String d : dictionary) {
            Trie cur = root;
            char[] chars = d.toCharArray();
            for (char c : chars) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie();
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        char[] sw = searchWord.toCharArray();
        return dfs(root, 0, false, sw);
    }

    private boolean dfs(Trie node, int pos, boolean modified, char[] sw) {
        if (pos == sw.length) {
            return modified && node.isEnd;
        }

        int idx = sw[pos] - 'a';
        if (node.children[idx] != null) {
            if (dfs(node.children[idx], pos + 1, modified, sw)) {
                return true;
            }
        }

        if (!modified) {
            for (int i = 0; i < 26; i++) {
                if (i != idx && node.children[i] != null) {
                    if (dfs(node.children[i], pos + 1, true, sw)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Trie {
    boolean isEnd;
    Trie[] children;
    Trie () {
        children = new Trie[26];
    }
}
