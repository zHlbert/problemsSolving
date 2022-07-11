package leetcode._28;

/**
 * https://leetcode.cn/problems/implement-strstr/
 *
 */
public class ImplementStrStr {

    /**
     * KMP算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] next = new int[m];
        char[] ne = needle.toCharArray();
        getNext(next, ne);
        int n = haystack.length();
        char[] ha = haystack.toCharArray();
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && ha[i] != ne[j]) {
                j = next[j - 1];
            }
            if (ha[i] == ne[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, char[] ne) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < ne.length; i++) {
            while (j > 0 && ne[i] != ne[j]) {
                j = next[j - 1];
            }
            if (ne[i] == ne[j]) {
                j++;
            }
            next[i] = j;
        }
    }
}
