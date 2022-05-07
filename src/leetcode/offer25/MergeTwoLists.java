package leetcode.offer25;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l0 = new ListNode(0);
        ListNode l = l0;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        l.next = (l1 != null ? l1 : l2);
        return l0.next;
    }

    public static void main(String[] args) {
        MergeTwoLists m = new MergeTwoLists();
        ListNode l1 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{1,2,5});
        ListNode l2 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{1,3});
        LinkedListUtils.printLinkedListNoExtra(m.mergeTwoLists(l1, l2));
    }
}
