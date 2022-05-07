package leetcode._22;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder s, int open, int close, int n) {
        if (s.length() == 2 * n) {
            res.add(s.toString());
            return;
        }
        if (open < n) {
            s.append('(');
            backtrack(res, s, open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }
        if (close < open) {
            s.append(')');
            backtrack(res, s, open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
//        System.out.println(g.generateParenthesis(1));
//        System.out.println(g.generateParenthesis(2));
        System.out.println(g.generateParenthesis(3));
    }
}
