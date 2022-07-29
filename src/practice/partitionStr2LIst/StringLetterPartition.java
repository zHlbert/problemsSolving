package practice.partitionStr2LIst;

import java.util.ArrayList;
import java.util.List;

/**
 * you are given a string 's'. We want to partition the string into as many as possible
 * so that each letter appears in at most one part.
 *
 * Return a list og integers representing the size of these parts
 *
 * Input: s = "ababcbacadefegdehijhklij"
 *
 * "ababcbaca defegde hijhklij"
 *
 * Ouput: [9,7,8]
 */
public class StringLetterPartition {
    /**
     * 哈希表
     * @param str
     * @return
     */
    public List<Integer> partition(String str) {
        char[] chs = str.toCharArray();
        // 存放每个字母最后出现的下标
        int n = chs.length;
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[chs[i] - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        // 当前子串的最左下标
        int rm0 = 0;
        // 当前子串的最左字母的最右下标
        int curRm = last[chs[rm0] - 'a'];
        // 当前子串的最右下标
        int rm = curRm;
        while (rm < n) {
            // 找到当前子串最右下标
            for (int i = 1; i < curRm; i++) {
                rm = Math.max(rm, last[chs[i] - 'a']);
            }
            res.add(rm - rm0 + 1);
            if (rm == n - 1) {
                break;
            }
            rm0 = rm + 1;
            curRm = last[chs[rm0] - 'a'];
            rm = curRm;
        }
        return res;
    }

    public static void main(String[] args) {
        StringLetterPartition slp = new StringLetterPartition();
        String s = "ababcbacadefegdehijhklij";
        System.out.println(slp.partition(s));
    }
}
