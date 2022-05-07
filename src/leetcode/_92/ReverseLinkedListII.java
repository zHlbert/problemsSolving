package leetcode._92;

import utils.LinkedListUtils;
import utils.ListNode;

import java.util.LinkedList;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dumbHead = new ListNode(-1000);
        dumbHead.next = head;
        ListNode lPre = dumbHead;
        int c = 0;
        while (c < left - 1) {
            c++;
            lPre = lPre.next;
        }
        ListNode lStart = lPre.next;
        ListNode rEnd = lPre;
        while (c < right) {
            c++;
            rEnd = rEnd.next;
        }
        ListNode rNext = rEnd.next;
        ListNode[] listNodes = reverseBetween(lStart, rEnd);
        if (lPre != lStart) {
            lPre.next = listNodes[0];
        }
        listNodes[1].next = rNext;
        return dumbHead.next;
    }

    private ListNode[] reverseBetween(ListNode lStart, ListNode rEnd) {
        ListNode p = lStart;
        ListNode prev = rEnd.next;
        while (prev != rEnd) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[] {rEnd, lStart};
    }

    public static void main(String[] args) {
        ReverseLinkedListII r = new ReverseLinkedListII();
        ListNode head = LinkedListUtils.initializeLinkedListNoExtra(new int[] {2,5});
        head = r.reverseBetween(head, 1, 2);
        LinkedListUtils.printLinkedListNoExtra(head);
    }
}
