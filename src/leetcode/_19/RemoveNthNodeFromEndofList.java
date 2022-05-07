package leetcode._19;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Follow up: Could you do this in one pass?
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        int[] listArr = new int[] {1};
        ListNode head = LinkedListUtils.initializeLinkedList(listArr);
        LinkedListUtils.printLinkedList(head);

        head = removeNthFromEnd(head, 1);
        LinkedListUtils.printLinkedList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode secondNode = head;
        ListNode firstNode = head;
        while (n != 0) {
            firstNode = firstNode.next;
            n--;
        }
//        if (firstNode == null) {
//            return head.next;
//        }
        while (firstNode.next != null) {
            secondNode = secondNode.next;
            firstNode = firstNode.next;
        }

        ListNode deletingNode = secondNode.next;
        if (deletingNode != null) {
            secondNode.next = deletingNode.next;
        }
        return head;
    }
}
