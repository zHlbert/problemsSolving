package leetcode._707;

import java.util.ArrayList;
import java.util.List;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtIndex(0, 10);
        ll.addAtIndex(0, 20);
        ll.addAtIndex(1, 30);
        System.out.println(printLL(ll));
        System.out.println(ll.get(0));
    }

    private static List<Integer> printLL(MyLinkedList ll) {
        ListNode cur = ll.head0.next;
        List<Integer> res = new ArrayList<>();
        while (cur != ll.tail0) {
            res.add(cur.val);
            cur = cur.next;
        }
        return res;
    }
}

class MyLinkedList {

    ListNode head0, tail0;

    public MyLinkedList() {
        head0 = new ListNode(-1);
        tail0 = new ListNode(-1);
        head0.next = tail0;
        tail0.prev = head0;
    }

    public int get(int index) {
        ListNode cur = head0;
        while (cur != tail0 && index >= 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.prev = head0;
        head0.next.prev = node;
        node.next = head0.next;
        head0.next = node;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        node.next = tail0;
        tail0.prev.next = node;
        node.prev = tail0.prev;
        tail0.prev = node;
    }

    public void addAtIndex(int index, int val) {
        ListNode node = new ListNode(val), cur = head0;
        while (cur.next != tail0 && index > 0) {
            cur = cur.next;
            index--;
        }
        if (index > 0) {
            return;
        }
        node.prev = cur;
        cur.next.prev = node;
        node.next = cur.next;
        cur.next = node;
    }

    public void deleteAtIndex(int index) {
        ListNode cur = head0;
        while (cur.next != tail0 && index > 0) {
            cur = cur.next;
            index--;
        }
        if (index > 0 || cur.next == tail0) {
            return;
        }
        ListNode del = cur.next;
        cur.next = del.next;
        del.next.prev = cur;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int val) {
        this.val = val;
    }
}
