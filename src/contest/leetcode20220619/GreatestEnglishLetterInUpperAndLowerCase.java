package contest.leetcode20220619;

import java.util.HashSet;
import java.util.Set;

public class GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
//        int[] cnt = new int[26];
        boolean[][] upperLower = new boolean[26][2];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
//                cnt[c - 'A']++;
                upperLower[c - 'A'][0] = true;
            } else {
//                cnt[c - 'a']++;
                upperLower[c - 'a'][1] = true;
            }
        }

        Character maxCh = null;
        for (int i = 25; i >= 0; i--) {
            if (upperLower[i][0] && upperLower[i][1]) {
                maxCh = (char) ('A' + i);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (maxCh != null) {
            sb.append(maxCh);
        }
        return sb.toString();
    }
}
