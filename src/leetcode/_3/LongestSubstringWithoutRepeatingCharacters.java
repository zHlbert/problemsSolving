package leetcode._3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                charSet.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !charSet.contains(s.charAt(rk + 1))) {
                charSet.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int maxL = 0;
        // 记录字符出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            char ch = chars[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (j <= i && map.get(ch) > 1) {
                char jCh = chars[j];
                if (map.containsKey(jCh)) {
                    map.put(jCh, map.get(jCh) - 1);
                }
                j++;
            }
            maxL = Math.max(maxL, i - j + 1);
        }
        return maxL;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int maxL = 0;
        Map<Character, Integer> idxMap = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            char ch = chars[i];
            if (idxMap.containsKey(ch)) {
                j = Math.max(j, idxMap.get(ch) + 1);
            }
            maxL = Math.max(maxL, i - j + 1);
            idxMap.put(ch, i);
        }
        return maxL;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
//        System.out.println(l.lengthOfLongestSubstring2("abcabcbb"));
//        System.out.println(l.lengthOfLongestSubstring2("bbbbb"));
//        System.out.println(l.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring2("dvdf"));
    }
}
