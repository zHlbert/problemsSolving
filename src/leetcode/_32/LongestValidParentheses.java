package leetcode._32;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    public int longestValidParenthesesStack(String s) {
        int maxL = 0;
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        // 初始化参照物
        stack.push(-1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    maxL = Math.max(maxL, i - stack.peek());
                } else {
                    // 栈为空时，放入右括号参照物。从此开始重新计算长度
                    stack.push(i);
                }
            }
        }
        return maxL;
    }

    public int longestValidParentheses(String s) {
        int maxL = 0;
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxL = Math.max(maxL, left + left);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxL = Math.max(maxL, left + left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxL;
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        String[] ps = new String[] {"(()", ")()())", "", "()(()", ")("};
        for (String p : ps) {
            System.out.println(p + ": " + lvp.longestValidParentheses(p));
        }
    }
}
