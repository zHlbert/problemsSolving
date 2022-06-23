package leetcode._30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        for (String word : words) {
            if (!s.contains(word)) {
                return res;
            }
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        int oneLen = words[0].length(), wl = words.length, wordsLen = oneLen * wl, sl = s.length();
        if (wordsLen > sl) {
            return res;
        }
        for (int i = 0; i < oneLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> subMap = new HashMap<>();
            while (right + oneLen <= sl) {
                String word = s.substring(right, right + oneLen);
                right += oneLen;
                if (!wordsMap.containsKey(word)) {
                    left = right;
                    subMap.clear();
                    count = 0;
                } else {
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    count++;
                    while (subMap.get(word) > wordsMap.get(word)) {
                        String del = s.substring(left, left + oneLen);
                        subMap.put(del, subMap.get(del) - 1);
                        count--;
                        left += oneLen;
                    }
                    if (count == wl) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}
