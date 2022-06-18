package leetcode.offerII_29;

/**
 * https://leetcode.cn/problems/4ueAj6/
 */
public class Insert2SortedCycleList {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node front = head.next, tail = head;
        while (front != head) {
            if (front.val < tail.val) {
                if (front.val >= insertVal || insertVal >= tail.val) {
                    break;
                }
            }
            if (front.val >= insertVal && tail.val <= insertVal) {
                break;
            }
            front = front.next;
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.next = front;
        return head;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
