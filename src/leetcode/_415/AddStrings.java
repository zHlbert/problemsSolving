package leetcode._415;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int lenGap = Math.abs(len1 - len2);
        int len = Math.max(len1, len2);
        StringBuilder sb = new StringBuilder();
        int addN = 0;
        for (int i = len - 1; i >= 0; i--) {
            int index = i - lenGap;
            int n1 = len1 >= len2 ? num1.charAt(i) - '0': index >= 0 ? num1.charAt(index) - '0': 0;
            int n2 = len2 >= len1 ? num2.charAt(i) - '0': index >= 0 ? num2.charAt(index) - '0': 0;
            sb.append((n1 + n2 + addN) % 10);
            addN = (n1 + n2 + addN) / 10;
        }
        if (addN != 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        String num1 = "12";
        String num2 = "89";
        System.out.println(a.addStrings(num1, num2));
    }
}
