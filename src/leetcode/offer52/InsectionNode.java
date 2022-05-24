package leetcode.offer52;

import utils.ListNode;

public class InsectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        int loop = 0;
        while (p1 != p2) {
            if (p1 == headB) {
                loop++;
                if (loop == 2) {
                    return null;
                }
            }
            p1 = p1.next == null ? headB : p1.next;
            p2 = p2.next == null ? headA : p2.next;
        }
        return p1;
    }
}
