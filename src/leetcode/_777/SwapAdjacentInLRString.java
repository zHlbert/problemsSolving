package leetcode._777;

/**
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */
public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        char[] s = start.toCharArray(), e = end.toCharArray();
        int n = s.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'X')
                continue;
            while (j < n && e[j] == 'X')
                j++;
            if (j == n)
                return false;
            if (s[i] != e[j])
                return false;
            if (s[i] == 'L' && i < j)
                return false;
            if (s[i] == 'R' && i > j)
                return false;
            j++;
        }
        for (; j < n; j++) {
            if (e[j] != 'X')
                return false;
        }
        return true;
    }
}
