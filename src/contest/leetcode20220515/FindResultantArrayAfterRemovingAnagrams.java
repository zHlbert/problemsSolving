package contest.leetcode20220515;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-293/problems/find-resultant-array-after-removing-anagrams/
 */
public class FindResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        Map<String, String> anagramMap = new HashMap<>();
        for (String word : words) {
            int[] cnt = new int[26];
            for (char c : word.toCharArray()) {
                cnt[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    char ch = (char) ('a' + i);
                    sb.append(ch).append(cnt[i]);
                }
            }
            anagramMap.put(word, sb.toString());
        }
//        System.out.println(anagramMap);
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for (int i = 1, pre = 0; i < words.length; i++) {
            String preEncode = anagramMap.get(words[pre]);
            String curEncode = anagramMap.get(words[i]);
            if (!preEncode.equals(curEncode)) {
                res.add(words[i]);
                pre = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindResultantArrayAfterRemovingAnagrams fra = new FindResultantArrayAfterRemovingAnagrams();
        String[] words = new String[] {"abba","baba","bbaa","cd","cd"};
//        String[] words = new String[] {"a","b","c","d","e"};
        System.out.println(fra.removeAnagrams(words));
    }
}
