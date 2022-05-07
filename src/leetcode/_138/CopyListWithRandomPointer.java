package leetcode._138;

import utils.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        int c = 0;
        Map<Node, Integer> nodeIndexMap = new HashMap<>();
        List<Node> rNodeList = new ArrayList<>();
        Node copyHead = new Node(head.val);
        Node rNode = copyHead;
        Node oNode = head;
        rNodeList.add(rNode);
        nodeIndexMap.put(oNode, c);
        while (oNode.next != null) {
            c++;
            oNode = oNode.next;
            nodeIndexMap.put(oNode, c);
            rNode.next = new Node(oNode.val);
            rNode = rNode.next;
            rNodeList.add(rNode);
        }

        oNode = head;
        rNode = copyHead;
        while (oNode != null) {
            Node oRandom = oNode.random;
            if (oRandom == null) {
                rNode.random = null;
            } else {
                int index = nodeIndexMap.get(oRandom);
                rNode.random = rNodeList.get(index);
            }
            oNode = oNode.next;
            rNode = rNode.next;
        }
        return copyHead;
    }

    /**
     * 哈希
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> cachedNode = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            cachedNode.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            cachedNode.get(curr).next = cachedNode.get(curr.next);
            cachedNode.get(curr).random = cachedNode.get(curr.random);
            curr = curr.next;
        }
        return cachedNode.get(head);
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
