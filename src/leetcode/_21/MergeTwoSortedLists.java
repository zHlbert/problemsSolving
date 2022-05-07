package leetcode._21;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode ll = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ll.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                ll.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            ll = ll.next;
        }
        ll.next = l1 != null ? l1 : l2;
        return l.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = LinkedListUtils.initializeLinkedListNoExtra(new int[] {1,2,4});
        ListNode l2 = LinkedListUtils.initializeLinkedListNoExtra(new int[] {1,3,4});
        ListNode l = m.mergeTwoLists(l1, l2);
        LinkedListUtils.printLinkedListNoExtra(l);
    }

}
