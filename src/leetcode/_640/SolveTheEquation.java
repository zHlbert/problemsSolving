package leetcode._640;

/**
 * https://leetcode.cn/problems/solve-the-equation/
 */
public class SolveTheEquation {
    public String solveEquation(String equation) {
        char[] eq = equation.toCharArray();
        boolean left = true, add = true;
        int co = 0, num = 0, cur = 0;
        int n = eq.length;
        for (int i = 0; i < n; i++) {
            char c = eq[i];
            boolean addLeft = add && left || !add && !left;
            if (Character.isDigit(c)) {
                cur = cur * 10 + (c - '0');
                if (i == n - 1) {
                    num += addLeft ? -cur : cur;
                }
            } else {
                if (c == '+' || c == '-') {
                    num += addLeft ? -cur : cur;
                    add = c == '+';
                } else if (c == '=') {
                    num += addLeft ? -cur : cur;
                    add = true;
                    left = false;
                } else if (c == 'x') {
                    char pre = i != 0 ? eq[i - 1] : '+';
                    if (pre == '+' || pre == '-' || pre == '=') {
                        co += addLeft ? 1 : -1;
                    } else {
                        co += addLeft ? cur : -cur;
                    }
                }
                cur = 0;
            }
        }
        if (co == 0) {
            return num == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + num / co;
        }
    }

    public static void main(String[] args) {
        SolveTheEquation se = new SolveTheEquation();
//        String eq = "x+5-3+x=6+x-2";
//        String eq = "x=x";
//        String eq = "2x=x";
//        String eq = "2x+3x-6x=x+2";
        String eq = "1+1=x";
        System.out.println(se.solveEquation(eq));
    }
}
