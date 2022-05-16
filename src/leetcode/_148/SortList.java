package leetcode._148;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * https://leetcode.cn/problems/sort-list/
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 从中间断开
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(mid);

        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode root = LinkedListUtils.initializeLinkedListNoExtra(new int[]{4, 2, 1, 3});
        ListNode sorted = sl.sortList(root);
        LinkedListUtils.printLinkedListNoExtra(sorted);
    }
}
