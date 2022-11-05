package leetcode._1106;

public class ParsingABooleanExpression {
    int N = 100010;
    boolean[] numStack = new boolean[N];
    int numTop = 0;

    char[] opStack = new char[N];
    int opTop = 0;

    char[] cStack = new char[N];
    int cTop = 0;

    /**
     * 栈
     * @param expression
     * @return
     */
    public boolean parseBoolExpr(String expression) {
        char[] sc = expression.toCharArray();

        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (c == 'f' || c == 't') {
                numStack[++numTop] = c == 't';
            } else if (c == '&' || c == '|' || c == '!') {
                opStack[++opTop] = c;
                cStack[++cTop] = sc[++i];
            } else if (c == ')') {
                if (opStack[opTop] == '!') {
                    numStack[numTop] = !numStack[numTop];
                    opTop--;
                } else {
                    char op = opStack[opTop--];
                    while (cStack[cTop] != '(') {
                        boolean num2 = numStack[numTop--];
                        boolean num1 = numStack[numTop--];
                        cTop--;
                        boolean res = op == '&' ? num1 && num2 : num1 || num2;
                        numStack[++numTop] = res;
                    }
                }
                cTop--;
            } else {
                cStack[++cTop] = c;
            }
        }
        return numStack[numTop];
    }

    /**
     * 递归
     */
    int index = 0;
    public boolean parseBoolExprRecr(String expression) {
        char c = expression.charAt(index);
        if (c == 't' || c == 'f') {
            index++;
            return c == 't';
        }
        if (c == '!') {
            index += 2;
            boolean res = parseBoolExprRecr(expression);
            index++;
            return !res;
        }
        if (c == '&' || c == '|') {
            boolean res = c == '&';
            index++;
            do {
                index++;
                if (c == '&') {
                    res &= parseBoolExprRecr(expression);
                } else {
                    res |= parseBoolExprRecr(expression);
                }
            } while (expression.charAt(index) == ',');
            index++;
            return res;
        }
        return false;
    }
}
