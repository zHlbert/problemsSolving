package leetcode._567;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        char[] s1Arr = s1.toCharArray();
        for (char c : s1Arr) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0, j = 0, valid = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (s1Map.containsKey(c)) {
                s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
                if (s2Map.get(c).equals(s1Map.get(c))) {
                    valid++;
                }
            }
            while (j <= i && i - j + 1 >= s1.length()) {
                if (valid == s1Map.size()) {
                    return true;
                }
                char left = s2.charAt(j);
                if (s1Map.containsKey(left)) {
                    if (s1Map.get(left).equals(s2Map.get(left))) {
                        valid--;
                    }
                    s2Map.put(left, s2Map.get(left) - 1);
                }
                j++;
            }
        }
        return false;
    }

    public boolean checkInclusionArr(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        int[] need = new int[26];
        char[] chars1 = s1.toCharArray();
        for (char c : chars1) {
            need[c - 'a']++;
        }
        char[] chars2 = s2.toCharArray();
        for (int i = 0, j = 0; i < l2; i++) {
            int idx = chars2[i] - 'a';
            need[idx]--;
            while (j <= i && need[idx] < 0) {
                need[chars2[j] - 'a']++;
                j++;
            }
            if (i - j + 1 == l1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString ps = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(ps.checkInclusionArr(s1, s2));
    }
}
