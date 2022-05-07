package leetcode._146;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode() {}
        public DLinkNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode> ();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            add2Head(newNode);
            size++;
            if (size > capacity) {
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            move2Head(node);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode realTail = tail.prev;
        removeNode(realTail);
        return realTail;
    }

    private void removeNode(DLinkNode realTail) {
        realTail.prev.next = realTail.next;
        realTail.next.prev = realTail.prev;
    }

    private void add2Head(DLinkNode newNode) {
        newNode.prev = head;
        head.next.prev = newNode;
        newNode.next = head.next;
        head.next = newNode;
    }

    private void move2Head(DLinkNode node) {
        removeNode(node);
        add2Head(node);
    }
}
