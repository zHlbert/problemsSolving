package leetcode._232;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        int res;
        boolean empty;
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(3); // queue is: [1, 2, 3] (leftmost is front of the queue)
        myQueue.push(4); // queue is: [1, 2, 3, 4] (leftmost is front of the queue)
        res = myQueue.peek(); // return 1
        res = myQueue.pop(); // return 1, queue is [2]
        myQueue.push(5);
        empty = myQueue.empty(); // return false
        res = myQueue.pop();
        myQueue.push(6);
        res = myQueue.pop();
        res = myQueue.pop();
        res = myQueue.peek(); // return 1
        res = myQueue.pop();
        res = myQueue.pop();
        empty = myQueue.empty(); // return true
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {

    private final Deque<Integer> firstStack;

    private final Deque<Integer> secondStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        firstStack = new LinkedList<>();
        secondStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        firstStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}
