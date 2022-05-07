package leetcode._24;

import utils.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            // 待交换的两个节点
            ListNode tmp = cur.next;
            ListNode tmp1 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = tmp;
            cur.next.next.next = tmp1;

            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
