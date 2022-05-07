package leetcode._143;

import utils.LinkedListUtils;
import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {

    /**
     * 保存每个节点，再按给定顺序组成新链表
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        ListNode ptr = head;
        ListNode[] nodes = new ListNode[50005];
        int c = 0;
        while (ptr != null) {
            nodes[c] = ptr;
            ptr = ptr.next;
            c++;
        }

        ptr = head;
        ptr.next = nodes[c - 1];
        ptr = ptr.next;
        for (int i = 1; i <= c / 2; i++) {
            ListNode odd = nodes[i];
            ListNode even = nodes[c - 1 - i];
            ptr.next = odd;
            if (i == c - 1 - i) {
                ptr = ptr.next;
            } else {
                ptr.next.next = even;
                ptr = ptr.next.next;
            }
        }
        ptr.next = null;
    }

    // TODO: 寻找链表中点 + 链表逆序 + 合并链表

    public static void main(String[] args) {
        ReorderList r = new ReorderList();
        ListNode head = LinkedListUtils.initializeLinkedListNoExtra(new int[] {1,2,3,4,5,6});
        r.reorderList(head);
        LinkedListUtils.printLinkedListNoExtra(head);
    }
}
