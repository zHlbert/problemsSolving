package contest.leetcode20210620;

/**
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 *
 * 子字符串 是字符串中的一个连续的字符序列。
 */
public class LargestOddNumberInStr {
    public String largestOddNumber(String num) {
        int oddIndex = -1;
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            if ((int) digit % 2 == 1) {
                oddIndex = i;
            }
        }
        return num.substring(0, oddIndex + 1);
    }

    public static void main(String[] args) {
        String numStr = "35427";
        LargestOddNumberInStr l = new LargestOddNumberInStr();
        System.out.println(l.largestOddNumber(numStr));
    }
}
