package leetcode._946;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/validate-stack-sequences/
 */
public class ValidateStackSequences {
    /**
     * 栈模拟
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
