package leetcode._82;

import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dump = new ListNode(-200);
        dump.next = head;
        ListNode pre = dump;
        ListNode curr = head;
        ListNode post = curr;
        while (post != null) {
            while (post.next != null && post.next.val == curr.val) {
                post = post.next;
            }
            if (curr == post) {
                pre = pre.next;
                curr = curr.next;
                post = post.next;
            } else {
                pre.next = post.next;
                curr = post.next;
                post = curr;
            }
        }
        return dump.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode root = LinkedListUtils.initializeLinkedListNoExtra(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 5, 6, 6});
        root = r.deleteDuplicates(root);
        LinkedListUtils.printLinkedListNoExtra(root);
    }
}
