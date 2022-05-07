package utils;


/**
 * 链表工具类
 */
public class LinkedListUtils {
    /**
     * 初始化链表（加入额外头节点）
     * @param nums
     * @return
     */
    public static ListNode initializeLinkedList(int[] nums) {
        ListNode headNode = new ListNode(-1);
        if (nums == null || nums.length == 0) {
            return headNode;
        }
        ListNode preNode = headNode;
        int len = nums.length;
        for (int num : nums) {
            preNode.next = new ListNode(num);
            preNode = preNode.next;
        }
        return headNode;
    }

    /**
     * 初始化链表（未加入额外头节点）
     * @param nums
     * @return
     */
    public static ListNode initializeLinkedListNoExtra(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode headNode = new ListNode(-1);
        ListNode preNode = headNode;
        int len = nums.length;
        for (int num : nums) {
            preNode.next = new ListNode(num);
            preNode = preNode.next;
        }
        return headNode.next;
    }

    /**
     * 打印链表（加入额外头节点）
     * @param head
     */
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode currentNode = head.next;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
     * 打印链表（未加入额外头节点）
     * @param head
     */
    public static void printLinkedListNoExtra(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static ListNode getTailNode(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public static ListNode indexOf(ListNode head, int val) {
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                return p;
            }
        }
        return null;
    }
}
