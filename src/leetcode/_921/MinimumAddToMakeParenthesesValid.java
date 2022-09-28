package leetcode._921;

/**
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 */
public class MinimumAddToMakeParenthesesValid {
    /**
     * 贪心
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        char[] sc = s.toCharArray();
        int lr = 0, r = 0;
        for (char c : sc) {
            if (c == '(') {
                lr++;
            } else {
                if (lr > 0) {
                    lr--;
                } else {
                    r++;
                }
            }
        }
        return lr + r;
    }
}
