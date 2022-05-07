package leetcode._206;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = LinkedListUtils.initializeLinkedListNoExtra(nums);
        LinkedListUtils.printLinkedListNoExtra(head);

        ListNode newHead = reverseListRcr(head);
        LinkedListUtils.printLinkedListNoExtra(newHead);
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverseListRcr(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRcr(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 循环
     * @return
     */
    public static ListNode reverseListItr(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
