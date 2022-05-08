package contest.leetcode20220508;

public class Largest3SameDigitNumberInString {
    public String largestGoodInteger(String num) {
        int n = num.length();
        char[] chars = num.toCharArray();
        int maxDigit = -1;
        for (int i = 0; i < n - 2; i++) {
            if (chars[i] == chars[i + 1] && chars[i + 1] == chars[i + 2]) {
                maxDigit = Math.max(maxDigit, chars[i] - '0');
            }
        }
        if (maxDigit == -1) {
            return "";
        }
        return String.valueOf(maxDigit).repeat(3);
    }
}
