package leetcode._1021;

/**
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        StringBuilder resSb = new StringBuilder();
        int lr = 0, start = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                lr++;
            } else {
                lr--;
            }
            if (lr == 0) {
                resSb.append(s, start + 1, i);
                if (i < n - 1) {
                    start = i + 1;
                }
            }
        }
        return resSb.toString();
    }

    public String removeOuterParentheses1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int lr = -1;
        StringBuilder resSb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                if (lr >= 0) {
                    resSb.append('(');
                }
                lr++;
            } else {
                lr--;
                if (lr >= 0) {
                    resSb.append(')');
                }
            }
        }
        return resSb.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses rop = new RemoveOutermostParentheses();
        String s = "()()";
        System.out.println(rop.removeOuterParentheses1(s));
    }
}
