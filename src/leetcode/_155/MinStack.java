package leetcode._155;

import java.util.*;

public class MinStack {
    PriorityQueue<Integer> queue;
    Deque<Integer> stack;

    public MinStack() {
        queue = new PriorityQueue<>();
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        queue.offer(val);
    }

    public void pop() {
        int top = stack.pop();
        queue.remove(top);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}

class MinStack1 {

    // [0]表示当前元素值，[1]表示当前元素压入后栈中最小值
    Deque<int[]> stack;

    public MinStack1() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            stack.push(new int[] {val, Math.min(val, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}




