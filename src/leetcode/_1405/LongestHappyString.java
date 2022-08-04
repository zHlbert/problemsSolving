package leetcode._1405;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-happy-string/
 */
public class LongestHappyString {

    /**
     * 贪心
     * @param a
     * @param b
     * @param c
     * @return
     */
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[] {a, b, c};
        Integer[] idx = new Integer[3];
        for (int i = 0; i < 3; i++) {
            idx[i] = i;
        }

        while (true) {
            Arrays.sort(idx, (i, j) -> cnt[j] - cnt[i]);
            // System.out.println(idx[0] + " , " + idx[1] + " , " + idx[2]);
            // System.out.println(cnt[idx[0]] + " , " + cnt[idx[1]] + " , " + cnt[idx[2]]);
            boolean hasNext = false;
            for (int i : idx) {
                if (cnt[i] <= 0) {
                    break;
                }
                char ch = (char) ('a' + i);
                int len = sb.length();
                if (len >= 2 && sb.charAt(len - 2) == ch && sb.charAt(len - 1) == ch) {
                    continue;
                }
                hasNext = true;
                sb.append(ch);
                cnt[i]--;
                break;
            }
            if (!hasNext) {
                break;
            }
        }
        return sb.toString();
    }
}
