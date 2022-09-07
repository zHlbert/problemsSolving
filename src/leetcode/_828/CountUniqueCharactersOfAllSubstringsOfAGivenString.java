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
     * 哈希
     * @param s
     * @return
     */
    public int uniqueLetterString(String s) {
        char[] chars = s.toCharArray();
        List<Integer> idxs[] = new List[26];
        for (int i = 0; i < 26; i++) {
            idxs[i] = new ArrayList<>();
            idxs[i].add(-1);
        }

        int n = chars.length;
        for (int i = 0; i < n; i++) {
            idxs[chars[i] - 'A'].add(i);
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            List<Integer> idx = idxs[i];
            idx.add(n);
            Integer[] id = idx.toArray(new Integer[0]);
            for (int j = 1; j < idx.size() - 1; j++) {
                res += (id[j] - id[j - 1]) * (id[j + 1] - id[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountUniqueCharactersOfAllSubstringsOfAGivenString cu = new CountUniqueCharactersOfAllSubstringsOfAGivenString();
        System.out.println(cu.uniqueLetterString("LEETCODE"));
    }
}
