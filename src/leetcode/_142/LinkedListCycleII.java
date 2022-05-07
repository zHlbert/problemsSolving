package leetcode._142;

import leetcode._141.LinkedListCycle;
import utils.LinkedListUtils;
import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Notice that you should not modify the linked list.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p1 = head, p2 = head;
        while (p1 .next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p2 == null) {
                return null;
            }
            if (p1 == p2) {
                ListNode p = head;
                while (p != p1) {
                    p = p.next;
                    p1 = p1.next;
                }
                return p1;
            }
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p1 = head;
        Set<ListNode> s = new HashSet<>();
        while (p1 .next != null) {
            if (s.contains(p1)) {
                return p1;
            } else {
                s.add(p1);
            }
            p1 = p1.next;

        }
        return null;
    }

    public static void main(String[] args) {
        ListNode list = LinkedListUtils.initializeLinkedListNoExtra(new int[] {3,2,0,4});
        list.next.next.next.next = list.next;
        System.out.println(new LinkedListCycleII().detectCycle1(list).val);
    }
}
