package leetcode._817;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        int res = 0;
        ListNode node = head;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        while (node != null) {
            if (numSet.contains(node.val)) {
                node = node.next;
                while (node != null && numSet.contains(node.val)) {
                    node = node.next;
                }
                res++;
                if (node == null) {
                    break;
                }
            }
            node = node.next;
        }
        return res;
    }
}
