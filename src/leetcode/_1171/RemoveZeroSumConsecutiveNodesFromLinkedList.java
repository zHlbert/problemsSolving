package leetcode._1171;

import utils.ListNode;

import java.util.Arrays;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
//    public ListNode removeZeroSumSublists(ListNode head) {
//        int[] idx = new int[2010];
//        Arrays.fill(idx, -1);
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        int sum = 0, i = 0;
//        idx[sum + 1000] = i++;
//        ListNode p = head;
//        while (p != null) {
//            sum += p.val;
//            if (idx[sum + 1000] != -1) {
//                ListNode pre = dummy;
//                int i1 = 0;
//                while (i1 < idx[sum + 1000]) {
//                    pre = pre.next;
//                    i1++;
//                }
//                pre.next = p.next;
//            }
//            idx[sum + 1000] = i++;
//            p = p.next;
//        }
//        return dummy.next;
//    }

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode[] nodes = new ListNode[200010];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            sum += p.val;
            nodes[sum + 100000] = p;
        }
        sum = 0;
        for (ListNode p = dummy; p != null; p = p.next) {
            sum += p.val;
            p.next = nodes[sum + 100000].next;
        }
        return dummy.next;
    }
}
