package leetcode._691;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/stickers-to-spell-word/
 */
public class StickersToSpellWord {
    // 状态压缩DP
    public int minStickersDP(String[] stickers, String target) {
        int n = target.length();
        char[] tArr = target.toCharArray();
        // dp[state] 表示状态是state时最小贴纸数量（state为二进制，二进制中某一位为1表示该位所对应字母已被覆盖到）
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 空的字符需要贴纸数量为0
        dp[0] = 0;
        for (int bit = 0; bit < (1 << n); bit++) {
            if (dp[bit] == Integer.MAX_VALUE) {
                continue;
            }
            for (String sticker : stickers) {
                // 从当前bit出发，看使用这张贴纸能拼出target中的哪几位字母
                int state = bit;
                for (char sCh : sticker.toCharArray()) {
                    for (int i = 0; i < n; i++) {
                        // target的第i位是sticker中的当前字符，且target的这一位还没有被拼写过
                        if (tArr[i] == sCh && ((state >> i) & 1) == 0) {
                            // state第i位置为1
                            state |= (1 << i);
                            break;
                        }
                    }
                }
                // 从bit转移到state，只需要一步
                dp[state] = Math.min(dp[state], dp[bit] + 1);
            }
        }
        return dp[(1 << n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << n) - 1];
    }

    public int minStickersDP1(String[] stickers, String target) {
        int n = target.length();
        char[] tArr = target.toCharArray();
        // dp[state] 表示状态是state时最小贴纸数量（state为二进制，二进制中某一位为1表示该位所对应字母已被覆盖到）
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 空的字符需要贴纸数量为0
        dp[0] = 0;
        int[][] sChCnt = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                sChCnt[i][c - 'a']++;
            }
        }
        for (int bit = 0; bit < (1 << n); bit++) {
            if (dp[bit] == Integer.MAX_VALUE) {
                continue;
            }
            for (int i = 0; i < stickers.length; i++) {
                int state = bit;
                int[] tmpCnt = Arrays.copyOf(sChCnt[i], 26);
                for (int j = 0; j < n; j++) {
                    int idx = tArr[j] - 'a';
                    if (tmpCnt[idx] > 0 && ((state >> j) & 1) == 0) {
                        tmpCnt[idx]--;
                        state |= (1 << j);
                    }
                }
                // 从bit转移到state，只需要一步
                dp[state] = Math.min(dp[state], dp[bit] + 1);
            }
        }
        return dp[(1 << n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << n) - 1];
    }

    int INF = 50;
    int[] dp = new int[1 << 20];
    String[] ss;
    String t;
    int n;
    char[] tChars;
    int[][] sChCnt;

    public int minStickersDFS(String[] stickers, String target) {
        ss = stickers;
        t = target;
        n = target.length();
        tChars = target.toCharArray();
        Arrays.fill(dp, -1);
        int res = dfs(0);
        return res == INF ? -1 : res;
    }

    private int dfs(int state) {
        if (state == ((1 << n) - 1)) {
            return 0;
        }
        if (dp[state] != -1) {
            return dp[state];
        }
        int res = INF;
        for (String s : ss) {
            int newState = state;
            for (char c : s.toCharArray()) {
                for (int i = 0; i < n; i++) {
                    if (tChars[i] == c && ((newState >> i) & 1) == 0) {
                        newState |= (1 << i);
                        break;
                    }
                }
            }
            if (newState != state) {
                res = Math.min(res, dfs(newState) + 1);
            }
        }
        return dp[state] = res;
    }

    public int minStickersDFS1(String[] stickers, String target) {
        ss = stickers;
        t = target;
        n = target.length();
        tChars = target.toCharArray();
        Arrays.fill(dp, -1);
        sChCnt = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                sChCnt[i][c - 'a']++;
            }
        }
        int res = dfs1(0);
        return res == INF ? -1 : res;
    }

    private int dfs1(int state) {
        if (state == ((1 << n) - 1)) {
            return 0;
        }
        if (dp[state] != -1) {
            return dp[state];
        }
        int res = INF;
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            int newState = state;
            int[] tmpCnt = Arrays.copyOf(sChCnt[i], 26);
            for (int j = 0; j < n; j++) {
                int idx = tChars[j] - 'a';
                if (tmpCnt[idx] > 0 && ((newState >> j) & 1) == 0) {
                    tmpCnt[idx]--;
                    newState |= (1 << j);
                }
            }
            if (newState != state) {
                res = Math.min(res, dfs(newState) + 1);
            }
        }
        return dp[state] = res;
    }

    public static void main(String[] args) {
        StickersToSpellWord ssw = new StickersToSpellWord();
        String[] stickers = new String[] {"with", "example", "science"};
        String target = "thehat";
        System.out.println(ssw.minStickersDFS1(stickers, target));
    }
}
