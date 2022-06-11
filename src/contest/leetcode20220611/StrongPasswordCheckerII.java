package contest.leetcode20220611;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-80/problems/strong-password-checker-ii/
 */
public class StrongPasswordCheckerII {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) {
            return false;
        }
        String sp = "!@#$%^&*()-+";
        Set<Character> spSet = new HashSet<>();
        for (char c : sp.toCharArray()) {
            spSet.add(c);
        }
        boolean hasLow = false, hasUpper = false, hasDigit = false, hasSp = false;
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                hasLow = true;
            } else if (c >= 'A' && c <= 'Z') {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (spSet.contains(c)) {
                hasSp = true;
            }
        }
        if (!hasLow || !hasUpper || !hasDigit || !hasSp) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StrongPasswordCheckerII sp = new StrongPasswordCheckerII();
        String[] ss = new String[] {"IloveLe3tcode!", "Me+You--IsMyDream", "1aB!"};
        for (String s : ss) {
            System.out.println(sp.strongPasswordCheckerII(s));
        }
    }
}
