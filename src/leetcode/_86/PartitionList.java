package leetcode._86;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode.cn/problems/partition-list/
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1, cur2 = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                cur1.next = new ListNode(cur.val);
                cur1 = cur1.next;
            } else {
                cur2.next = new ListNode(cur.val);
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
//        ListNode head = LinkedListUtils.initializeLinkedListNoExtra(new int[]{1, 4, 3, 2, 5, 2});
        ListNode head = LinkedListUtils.initializeLinkedListNoExtra(new int[]{2,1});
        ListNode newHead = pl.partition(head, 2);
        LinkedListUtils.printLinkedListNoExtra(newHead);
    }
}
