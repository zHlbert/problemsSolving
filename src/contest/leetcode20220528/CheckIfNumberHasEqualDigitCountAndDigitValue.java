package contest.leetcode20220528;

/**
 * https://leetcode.cn/contest/biweekly-contest-79/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */
public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public boolean digitCount(String num) {
        char[] digits = num.toCharArray();
        int n = num.length();
        int[] occurs = new int[10];
        for (int i = 0; i < n; i++) {
            occurs[digits[i] - '0']++;
        }

        for (int i = 0; i < n; i++) {
            if (occurs[i] != digits[i] - '0') {
                return false;
            }
        }
        return true;
    }
}
