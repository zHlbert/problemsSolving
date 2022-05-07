package leetcode._23;

import leetcode._21.MergeTwoSortedLists;
import utils.LinkedListUtils;
import utils.ListNode;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l >= r) {
            return lists[r];
        }
        int mid = (l + r) >> 1;
        ListNode lList = mergeKLists(lists, l, mid);
        ListNode rList = mergeKLists(lists, mid + 1, r);
        ListNode ll = new ListNode(0);
        ListNode l0 = ll;
        while (lList != null && rList != null) {
            if (lList.val < rList.val) {
                ll.next = lList;
                lList = lList.next;
            } else {
                ll.next = rList;
                rList = rList.next;
            }
            ll = ll.next;
        }
        ll.next = lList != null ? lList : rList;
        return l0.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists m = new MergeKSortedLists();
        ListNode l1 = LinkedListUtils.initializeLinkedListNoExtra(new int[] {1,3,4});
        ListNode l2 = LinkedListUtils.initializeLinkedListNoExtra(new int[] {2,3,5});
        ListNode l3 = LinkedListUtils.initializeLinkedListNoExtra(new int[] {3,4,7});
        ListNode[] lists = new ListNode[] {l1, l2, l3};
        LinkedListUtils.printLinkedListNoExtra(m.mergeKLists(lists));
    }
}
