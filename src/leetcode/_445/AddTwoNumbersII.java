package leetcode._445;

import utils.LinkedListUtils;
import utils.ListNode;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode h = new ListNode(0);
        ListNode p = h;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + add;
            int s = sum % 10;
            add = sum / 10;
            p.next = new ListNode(s);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l3 = l1 != null ? l1 : l2;
        while (l3 != null) {
            int sum = l3.val + add;
            int s = sum % 10;
            add = sum / 10;
            p.next = new ListNode(s);
            p = p.next;
            l3 = l3.next;
        }
        if (add != 0) p.next = new ListNode(1);
        ListNode p1 = h.next;
        h.next = null;
        return reverseList(p1);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        AddTwoNumbersII atn = new AddTwoNumbersII();
        ListNode l1 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{7, 2, 4, 3});
        ListNode l2 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{5, 6, 4});
        LinkedListUtils.printLinkedListNoExtra(atn.addTwoNumbers(l1, l2));
    }
}
