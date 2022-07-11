package leetcode._1381;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignAStackWithIncrementOperation {

}

/**
 * 双栈
 */
class CustomStack {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    int m;

    public CustomStack(int maxSize) {
        m = maxSize;
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<> ();
    }

    public void push(int x) {
        if (stack1.size() < m) {
            stack1.push(x);
        }
    }

    public int pop() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }

    public void increment(int k, int val) {
        int incNum = Math.min(k, stack1.size());
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int i = 0;
        while (!stack2.isEmpty()) {
            int nv = stack2.pop();
            if (i < incNum) {
                nv += val;
            }
            stack1.push(nv);
            i++;
        }
    }
}

/**
 * 数组模拟栈，add 数组记录增加值
 */
class CustomStack1 {

    int[] stack, add;
    int top, m;

    public CustomStack1(int maxSize) {
        stack = new int[maxSize];
        add = new int[maxSize];
        m = maxSize;
        top = -1;
    }

    public void push(int x) {
        if (top < m - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        // 计算返回值
        int res = stack[top] + add[top];
        // 增加值向下传递
        if (top > 0) {
            add[top - 1] += add[top];
        }
        // 复原
        add[top] = 0;
        // 栈顶回退
        top--;
        return res;
    }

    public void increment(int k, int val) {
        // 只需在第 min(k - 1, top) 位记录增加值
        int limit = Math.min(k - 1, top);
        if (limit >= 0) {
            add[limit] += val;
        }
    }
}
