package leetcode._173;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

}

class BSTIterator {
    List<Integer> inorderList;
    int idx;

    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<>();
        inorder(root);
        idx = 0;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }

    public int next() {
        int curVal = inorderList.get(idx);
        idx++;
        return curVal;
    }

    public boolean hasNext() {
        return idx < inorderList.size();
    }
}

class BSTIterator1 {
    TreeNode rootNode;
    TreeNode cur;

    public BSTIterator1(TreeNode root) {
        this.rootNode = root;
        cur = findFirst(root);
    }

    private TreeNode findFirst(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = findFirst(root.left);
        return left != null ? left : root;
    }

    public int next() {
        TreeNode tmpRoot = rootNode;
        TreeNode tmpCur = cur;
        int res = cur != null ? cur.val : 0;
        cur = findNext(tmpRoot, tmpCur);
        return res;
    }

    private TreeNode findNext(TreeNode root, TreeNode tmpCur) {
        if (root == null) {
            return null;
        }
        if (tmpCur.val >= root.val) {
            return findNext(root.right, tmpCur);
        }
        TreeNode left = findNext(root.left, tmpCur);
        if (left == null) {
            return root;
        }
        return left.val < root.val ? left : root;
    }

    public boolean hasNext() {
        return cur != null;
    }
}
