package leetcode._241;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int num = 0;
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                nums.add(num);
                ops.add(c);
                num = 0;
            }
        }
        nums.add(num);
        int n = nums.size();
        List<Integer>[][] res = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = new ArrayList<>();
            }
            res[i][i].add(nums.get(i));
        }
        // 循环范围
        for (int d = 0; d < n; d++) {
            // 分为左右两部分
            for (int i = 0; i + d < n; i++) {
                for (int j = i; j < i + d; j++) {
                    List<Integer> l = res[i][j], r = res[j + 1][i + d];
                    char op = ops.get(j);
                    for (int ln : l) {
                        for (int rn : r) {
                            res[i][i + d].add(compute(ln, rn, op));
                        }
                    }
                }
            }
        }

        return res[0][n - 1];
    }

    private int compute(int a, int b, char op) {
        return op == '+' ? a + b : (op == '-' ? a - b : a * b);
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses dw = new DifferentWaysToAddParentheses();
        String expression = "2*13+8*21-25*5";
        System.out.println(dw.diffWaysToCompute(expression));
    }
}
