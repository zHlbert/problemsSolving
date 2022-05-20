package leetcode.offer33;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTPostOrder {
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        // 单调栈 栈顶元素最大
        Deque<Integer> stack = new ArrayDeque<>(n);
        int root = Integer.MAX_VALUE;
        // 后序遍历 倒过来是 根右左的顺序
        for (int i = n - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
