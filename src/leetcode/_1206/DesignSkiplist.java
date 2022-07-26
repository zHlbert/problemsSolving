package leetcode._1206;

import java.util.Random;

/**
 * https://leetcode.cn/problems/design-skiplist/
 */
public class DesignSkiplist {

}

/**
 * https://leetcode.cn/problems/design-skiplist/solution/by-ac_oier-38rd/
 */
class Skiplist {
    int level = 10;
    class Node {
        int val;
        Node[] ne = new Node[level];
        Node (int val) {
            this.val = val;
        }
    }

    Random random;
    Node he;

    public Skiplist() {
        random = new Random();
        he = new Node(-1);
    }

    public boolean search(int target) {
        Node[] ns = new Node[level];
        find(target, ns);
        return ns[0].ne[0] != null && ns[0].ne[0].val == target;
    }

    private void find(int target, Node[] ns) {
        Node cur = he;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < target) {
                cur = cur.ne[i];
            }
            ns[i] = cur;
        }
    }

    public void add(int num) {
        Node[] ns = new Node[level];
        find(num, ns);
        Node node = new Node(num);
        for (int i = 0; i < level; i++) {
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if (random.nextInt(2) == 0) {
                break;
            }
        }
    }

    public boolean erase(int num) {
        Node[] ns = new Node[level];
        find(num, ns);
        Node node = ns[0].ne[0];
        if (node == null || node.val != num)
            return false;
        for (int i = 0; i < level && ns[i].ne[i] == node; i++) {
            ns[i].ne[i] = ns[i].ne[i].ne[i];
        }
        return true;
    }
}
