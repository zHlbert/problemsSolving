package leetcode._965;

import utils.TreeNode;

public class UnivaluedBinaryTree {
    int val;
    public boolean isUnivalTree(TreeNode root) {
        val = root.val;
        return univalTree(root);
    }

    private boolean univalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return univalTree(root.left) && univalTree(root.right);
    }
}
