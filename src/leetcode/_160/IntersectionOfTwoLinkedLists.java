package leetcode._160;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lA = headA;
        ListNode lB = headB;
        int aMinusB = 0;
        while (lA != null || lB != null) {
            if (lA == lB)
                return lA;
            if (lA != null && lB != null) {
                lA = lA.next;
                lB = lB.next;
            } else if (lA != null) {
                lA = lA.next;
                aMinusB++;
            } else {
                lB = lB.next;
                aMinusB--;
            }
        }
        int init = aMinusB < 0 ? -aMinusB : aMinusB;
        lA = headA;
        lB = headB;
        if (aMinusB < 0) {
            for (int j = 0; j < init; j++)
                lB = lB.next;
        } else if (aMinusB > 0) {
            for (int j = 0; j < init; j++)
                lA = lA.next;
        }
        while (lA != null) {
            if (lA == lB)
                return lA;
            lA = lA.next;
            lB = lB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeSimple(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists intersection = new IntersectionOfTwoLinkedLists();
        ListNode headA = LinkedListUtils.initializeLinkedListNoExtra(new int[] {4,1,8,4,5});
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
//        ListNode headB = LinkedListUtils.initializeLinkedListNoExtra(new int[] {3,2});
        LinkedListUtils.printLinkedListNoExtra(headB);
        ListNode intersectionNode = intersection.getIntersectionNodeSimple(headA, headB);
        System.out.println(intersectionNode == null ? 0 : intersectionNode.val);
    }
}
