package contest.leetcode20220807;

import java.util.ArrayList;
import java.util.List;

public class LongestIdealSubsequence {
//    public int longestIdealString(String s, int k) {
//        char[] chars = s.toCharArray();
//        int n = chars.length;
//        int len = 1;
//        int[] d = new int[n + 1];
//        d[len] = chars[0];
//        for (int i = 1; i < n; i++) {
//            if (Math.abs(chars[i] - d[len]) <= k) {
//                d[++len] = chars[i];
//            } else {
//                int l = 1, r = len + 1, pos = 0;
//                while (l < r) {
//                    int mid = (l + r) >> 1;
//
//                }
//            }
//        }
//    }

//    public int longestIdealString(String s, int k) {
//        List<Character>[] chList = new List[26];
//        for (int i = 0; i < 26; i++) {
//            chList[i] = new ArrayList<>();
//        }
//
//        char[] chars = s.toCharArray();
//        return 0;
//    }

    /**
     * 贪心
     * @param s
     * @param k
     * @return
     */
    public int longestIdealString(String s, int k) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        int res = 0;
        for (char c : chars) {
            int idx = c - 'a';
            for (int i = Math.max(0, idx - k); i <= Math.min(25, idx + k); i++) {
                cnt[idx] = Math.max(cnt[idx], cnt[i]);
            }
            cnt[idx]++;
        }

        for (int c : cnt) {
            res = Math.max(res, c);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIdealSubsequence lis = new LongestIdealSubsequence();
        String s = "azaza";
        int k = 25;
        System.out.println(lis.longestIdealString(s, k));
    }
}
