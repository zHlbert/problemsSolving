package leetcode._791;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 自定义字符串排序
 */
public class CustomSortString {
    public String customSortString(String order, String s) {
        char[] oc = order.toCharArray();
        int[] idx = new int[26];
        Arrays.fill(idx, oc.length);
        for (int i = 0; i < oc.length; i++) {
            idx[oc[i] - 'a'] = i;
        }
        Character[] sc = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sc[i] = s.charAt(i);
        }
        Arrays.sort(sc, Comparator.comparingInt(c -> idx[c - 'a']));
        StringBuilder sb = new StringBuilder();
        for (Character c : sc) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String customSortString1(String order, String s) {
        int[] cnt = new int[26];
        char[] sc = s.toCharArray();
        // 计数排序
        for (char c : sc) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            sb.append(String.valueOf(c).repeat(Math.max(0, cnt[c - 'a'])));
            cnt[c - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            sb.append(String.valueOf(c).repeat(Math.max(0, cnt[i])));
        }
        return sb.toString();
    }
}
