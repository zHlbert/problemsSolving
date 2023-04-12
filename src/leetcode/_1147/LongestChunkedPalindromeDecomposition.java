package leetcode._1147;

public class LongestChunkedPalindromeDecomposition {
    /**
     * 贪心 + 双指针
     * https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/solution/duan-shi-hui-wen-by-leetcode-solution-vanl/
     * @param text
     * @return
     */
    public int longestDecomposition(String text) {
        char[] sc = text.toCharArray();
        int n = sc.length;
        int res = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int len = 1;
            while (l + len - 1 < r - len + 1) {
                if (judge(sc, l, r - len + 1, len)) {
                    res += 2;
                    break;
                }
                len++;
            }
            if (l + len - 1 >= r - len + 1) {
                res++;
            }
            l += len;
            r -= len;
        }
        return res;
    }

    private boolean judge(char[] sc, int l1, int l2, int len) {
        while (len > 0) {
            if (sc[l1] != sc[l2]) return false;
            l1++;
            l2++;
            len--;
        }
        return true;
    }

    // TODO: 2023/4/12 滚动哈希
}
