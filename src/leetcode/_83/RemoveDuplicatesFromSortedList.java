package leetcode._83;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next, pre = head;
        while (cur != null) {
            int val = pre.val;
            while (cur != null && cur.val == val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = pre.next;
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
        ListNode list = LinkedListUtils.initializeLinkedListNoExtra(new int[]{1,2});
        LinkedListUtils.printLinkedListNoExtra(rd.deleteDuplicates(list));
    }
}
