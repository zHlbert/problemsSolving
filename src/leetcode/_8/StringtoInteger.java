package leetcode._8;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringtoInteger {
    public int myAtoi(String s) {
        int sign = 1;
        int res = 0;
        int len = s.length();
        int i = 0;
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        int start = i;
        for (; i < len; i++) {
            char c = s.charAt(i);
            if (i == start && (c == '-' || c == '+')) {
                sign = c == '-' ? -1 : 1;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * num;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StringtoInteger s = new StringtoInteger();
        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi("    -42"));
        System.out.println(s.myAtoi("4193 with words"));
        System.out.println(s.myAtoi("words and 987"));
        System.out.println(s.myAtoi("-91283472332"));
        System.out.println(s.myAtoi("-2147483648"));
        System.out.println(s.myAtoi("-2147483649"));
        System.out.println(s.myAtoi("2147483649"));
        System.out.println(s.myAtoi("2147483648"));
        System.out.println(s.myAtoi("2147483647"));
        System.out.println(s.myAtoi("2147483646"));
    }
}
