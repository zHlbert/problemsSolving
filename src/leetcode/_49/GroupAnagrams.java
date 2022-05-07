package leetcode._49;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            int[] chCount = new int[26];
            char[] chars = str.toCharArray();
            for (char ch : chars) {
                chCount[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chCount.length; i++) {
                if (chCount[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(chCount[i]);
                }
            }
            return sb.toString();
        })).values());
    }

    public List<List<String>> groupAnagramsManual(String[] strs) {
        Map<String, List<String>> chCountMap = new HashMap<>();
        for (String str : strs) {
            int[] chCount = new int[26];
            char[] chars = str.toCharArray();
            for (char ch : chars) {
                chCount[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chCount.length; i++) {
                if (chCount[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(chCount[i]);
                }
            }
            String encodeKey = sb.toString();
            List<String> strList = chCountMap.getOrDefault(encodeKey, new ArrayList<>());
            strList.add(str);
            chCountMap.put(encodeKey, strList);
        }
        return new ArrayList<>(chCountMap.values());
    }
}
