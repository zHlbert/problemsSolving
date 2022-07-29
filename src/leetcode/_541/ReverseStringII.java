package leetcode._541;

public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        for (int i = 0; i < n; i += 2 * k) {
            reverse(chs, i, Math.min(n, i + k) - 1);
        }
        return new String(chs);
    }

    private void reverse(char[] chs, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            char t = chs[i];
            chs[i] = chs[j];
            chs[j] = t;
        }
    }
}
