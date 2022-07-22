package leetcode._919;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/complete-binary-tree-inserter/
 */
public class CompleteBinaryTreeInserter {

}

class CBTInserter {

    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        boolean insertion = false;
        int pVal = root.val;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                } else if (!insertion) {
                    cur.left = new TreeNode(val);
                    insertion = true;
                    pVal = cur.val;
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                } else if (!insertion) {
                    cur.right = new TreeNode(val);
                    insertion = true;
                    pVal = cur.val;
                    queue.offer(cur.right);
                }
            }
        }
        return pVal;
    }

    public TreeNode get_root() {
        return root;
    }
}

class CBTInserter1 {

//    TreeNode root;
//    int pVal;
//
//    public CBTInserter1(TreeNode root) {
//        this.root = root;
//        pVal = root.val;
//    }
//
//    public int insert(int val) {
//        return insertInter(root, val);
//    }
//
//    private int insertInter(TreeNode root, int val) {
////        if (ins || root == null) {
////            return;
////        }
//        if (root.left == null) {
//            root.left = new TreeNode(val);
//            return root.val;
//        } else {
//            return insertInter(root.left, val);
//        }
//        if (root.right == null) {
//            root.right = new TreeNode(val);
//            return root.val;
//        } else {
//            insertInter(root.right, val);
//        }
//    }
//
//    public TreeNode get_root() {
//        return root;
//    }
}

/**
 * 初始化时把待插入节点的父节点存入队列
 */
class CBTInserter2 {

    TreeNode root;
    // 队列中每个元素子节点待插入
    Deque<TreeNode> cdd;

    public CBTInserter2(TreeNode root) {
        this.root = root;
        cdd = new ArrayDeque<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty())  {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null || node.right == null) {
                    cdd.offer(node);
                }
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode parent = cdd.peek();
        int ret = parent.val;
        if (parent.left == null) {
            parent.left = child;
        } else if (parent.right == null) {
            parent.right = child;
            cdd.poll();
        }
        cdd.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        return root;
    }
}
