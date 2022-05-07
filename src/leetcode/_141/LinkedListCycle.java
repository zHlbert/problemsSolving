package leetcode._141;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head, p2 = head;
        while (p1.next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p2 == null) {
                return false;
            }
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.initializeLinkedListNoExtra(new int[] {3,2,0,4});
        list.next.next.next.next = list.next;
        System.out.println(new LinkedListCycle().hasCycle(list));
    }
}
