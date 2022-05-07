package leetcode._25;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] nodes = rangeReverse(head, tail);
            head = nodes[0];
            tail = nodes[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] rangeReverse(ListNode head, ListNode tail) {
        ListNode p = head;
        ListNode prev = tail.next;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[] {tail, head};
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.initializeLinkedListNoExtra(new int[] {1, 2, 3, 4, 5});
//        ListNode tail = LinkedListUtils.getTailNode(head);
        ReverseNodesInKGroup r = new ReverseNodesInKGroup();
//        ListNode[] pair = r.rangeReverse(head, tail);
//        LinkedListUtils.printLinkedListNoExtra(pair[0]);
        LinkedListUtils.printLinkedListNoExtra(r.reverseKGroup(head, 1));
        ListNode head1 = LinkedListUtils.initializeLinkedListNoExtra(new int[] {1});
        LinkedListUtils.printLinkedListNoExtra(r.reverseKGroup(head1, 1));
    }
}
