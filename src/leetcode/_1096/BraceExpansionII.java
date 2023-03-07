package leetcode._1096;

import java.util.*;

/**
 * https://leetcode.cn/problems/brace-expansion-ii/
 */
public class BraceExpansionII {
    char[] exp;
    int idx;

    /**
     * dfs
     * @param expression
     * @return
     */
    public List<String> braceExpansionII(String expression) {
        this.exp = expression.toCharArray();
        this.idx = 0;
        Set<String> res = expr();
        return new ArrayList<>(res);
    }

    private Set<String> expr() {
        Set<String> res = new TreeSet<>();
        while (true) {
            res.addAll(term());
            if (idx < exp.length && exp[idx] == ',') {
                idx++;
            } else break;
        }
        return res;
    }

    private Set<String> term() {
        Set<String> res = new TreeSet<>();
        res.add("");
        while (idx < exp.length && (exp[idx] == '{' || Character.isLetter(exp[idx]))) {
            Set<String> sub = item();
            Set<String> tmp = new TreeSet<>();
            for (String left : res) {
                for (String right : sub) {
                    tmp.add(left + right);
                }
            }
            res = tmp;
        }
        return res;
    }

    private Set<String> item() {
        Set<String> res = new TreeSet<>();
        if (exp[idx] == '{') {
            idx++;
            res = expr();
        } else {
            res.add(String.valueOf(exp[idx]));
        }
        idx++;
        return res;
    }
}
