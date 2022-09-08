package leetcode._828;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 */
public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
//    public int uniqueLetterString(String s) {
//        char[] chars = s.toCharArray();
//        int n = chars.length;
//        int[] last = new int[26];
//        Arrays.fill(last, -1);
//        int[] dp = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            char c = chars[i];
//            int preIdx = last[c - 'A'];
//            boolean exists = preIdx >= 0;
//            dp[i + 1] = dp[i] + (i - preIdx) * (i - preIdx + 1) / 2;
//            last[c - 'A'] = i;
//        }
//        return dp[n];
//    }

    /**
     * https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/solution/tong-ji-zi-chuan-zhong-de-wei-yi-zi-fu-b-h9pj/
     *
     * 哈希
     *
     * 该问题可以转化为所有子字符串中26个字符是否出现的次数（出现 为 1 否则为 0）
     * @param s
     * @return
     */
    public int uniqueLetterString(String s) {
        char[] chars = s.toCharArray();
        // 保存每个字符在字符串中出现的位置
        List<Integer> idxs[] = new List[26];
        for (int i = 0; i < 26; i++) {
            idxs[i] = new ArrayList<>();
            // 从 -1 开始
            idxs[i].add(-1);
        }

        int n = chars.length;
        for (int i = 0; i < n; i++) {
            idxs[chars[i] - 'A'].add(i);
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            List<Integer> idx = idxs[i];
            // 以 n 结尾
            idx.add(n);
            Integer[] id = idx.toArray(new Integer[0]);
            for (int j = 1; j < idx.size() - 1; j++) {
                // 共有 (id[j] - id[j - 1]) * (id[j + 1] - id[j]) 个字符串出现了 字符 ('A' + i)
                res += (id[j] - id[j - 1]) * (id[j + 1] - id[j]);
            }
        }
        return res;
    }

    /**
     * 哈希 滚动数组
     * @param s
     * @return
     */
    public int uniqueLetterString1(String s) {
        char[] cs = s.toCharArray();

        // 字符上次出现的位置
        int[] pIdx = new int[26];
        // 字符最近出现的位置
        int[] idx = new int[26];
        Arrays.fill(pIdx, -1);
        Arrays.fill(idx, -1);

        int res = 0;
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            int c = cs[i] - 'A';
            if (idx[c] > -1) {
                res += (idx[c] - pIdx[c]) * (i - idx[c]);
            }
            pIdx[c] = idx[c];
            idx[c] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (idx[i] > -1) {
                res += (n - idx[i]) * (idx[i] - pIdx[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountUniqueCharactersOfAllSubstringsOfAGivenString cu = new CountUniqueCharactersOfAllSubstringsOfAGivenString();
        System.out.println(cu.uniqueLetterString1("LEETCODE"));
    }
}
