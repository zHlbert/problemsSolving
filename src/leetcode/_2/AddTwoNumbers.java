package leetcode._2;

import utils.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int bonus = 0;
        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + bonus;
            newNode.next = new ListNode(sum % 10);
            bonus = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            newNode = newNode.next;
        }
        ListNode remainNode = l1 != null ? l1 : l2;
        while (remainNode != null) {
            int sum = remainNode.val + bonus;
            newNode.next = new ListNode(sum % 10);
            bonus = sum / 10;
            remainNode = remainNode.next;
            newNode = newNode.next;
        }
        if (bonus > 0) {
            newNode.next = new ListNode(bonus);
        }
        return dummy.next;
    }
}
