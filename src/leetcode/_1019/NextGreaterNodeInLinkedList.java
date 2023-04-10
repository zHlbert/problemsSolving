package leetcode._1019;

import utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterNodeInLinkedList {
    /**
     * 单调栈
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> deque = new ArrayDeque<>();
        int c = 0;
        ListNode p = head;
        int[] idx2NxtGreater = new int[10010];
        while (p != null) {
            while (!deque.isEmpty() && deque.peek()[0] < p.val) {
                int[] pre = deque.pop();
                idx2NxtGreater[pre[1]] = p.val;
            }
            deque.push(new int[] {p.val, c++});
            p = p.next;
        }
        int[] res = new int[c];
        for (int i = 0; i < c; i++) {
            res[i] = idx2NxtGreater[i];
        }
        return res;
    }
}
