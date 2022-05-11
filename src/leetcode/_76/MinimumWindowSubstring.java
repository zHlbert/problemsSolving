package leetcode._76;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }
        if (s.equals(t)) {
            return t;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] need = new int[52];
        for (char tChar : tChars) {
            need[getIdx(tChar)]++;
        }
        int start = 0, count = n, size = Integer.MAX_VALUE;
        for (int r = 0, l = 0; r < m; r++) {
            int idx = getIdx(sChars[r]);
            if (need[idx] > 0) {
                count--;
            }
            need[idx]--;
            // 滑动窗口
            // 窗口已包含所有字符
            if (count == 0) {
                while (l < r && need[getIdx(sChars[l])] < 0) {
                    need[getIdx(sChars[l])]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                // 窗口左侧右移，寻找下一个满足条件的子串
                need[getIdx(sChars[l])]++;
                l++;
                count++;
            }
//            System.out.println("r: " + r + ", l: " + l + ", count: " + count + ", start: " + start + ", size: " + size);
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    private int getIdx(char ch) {
        return Character.isUpperCase(ch) ? ch - 'A' + 26 : ch - 'a';
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(mws.minWindow(s, t));
    }
}
