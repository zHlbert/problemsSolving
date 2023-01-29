package leetcode._1669;

import utils.LinkedListUtils;
import utils.ListNode;

public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1;
        int c = 0;
        for (; c < a - 1; c++) p = p.next;
        ListNode p0 = p;
        for (; c <= b; c++) p = p.next;
        ListNode p2 = list2;
        while (p2.next != null) p2 = p2.next;
        p0.next = list2;
        p2.next = p;
        return list1;
    }

    public static void main(String[] args) {
        MergeInBetweenLinkedLists mll = new MergeInBetweenLinkedLists();
//        ListNode list1 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{0, 1, 2, 3, 4, 5});
//        ListNode list2 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{1000, 1001, 1002});
//        int[] ab = new int[] {3,4};
//        ListNode list1 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{0, 1, 2, 3, 4, 5, 6});
//        ListNode list2 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{1000, 1001, 1002, 1003, 1004});
//        int[] ab = new int[] {2,5};
        ListNode list1 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{0, 1, 2, 3, 4, 5, 6});
        ListNode list2 = LinkedListUtils.initializeLinkedListNoExtra(new int[]{1000, 1001, 1002, 1003, 1004});
        int[] ab = new int[] {1,6};
        LinkedListUtils.printLinkedListNoExtra(mll.mergeInBetween(list1, ab[0], ab[1], list2));
    }
}

