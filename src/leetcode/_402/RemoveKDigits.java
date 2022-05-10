package leetcode._402;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/remove-k-digits/
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        char[] digits = num.toCharArray();
        // 单调栈 栈底到栈顶单调不降
        Deque<Character> deque = new ArrayDeque<>(num.length());
        for (char digit : digits) {
            while (!deque.isEmpty() && deque.peekFirst() > digit && k > 0) {
                deque.pollFirst();
                k--;
            }
            deque.offerFirst(digit);
        }

        // k仍然大于0时，弹出栈顶数
        for (; k > 0; k--) {
            deque.pollFirst();
        }

        StringBuilder resSb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollLast();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            resSb.append(digit);
        }
        return resSb.length() == 0 ? "0" : resSb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits rkd = new RemoveKDigits();
        String num = "5009";
        int k = 2;
        System.out.println(rkd.removeKdigits(num, k));
    }
}
