package leetcode._814;

import utils.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-pruning/
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.left == null && root.right == null && root.val == 0 ? null : root;
    }

    public static void main(String[] args) {
        BinaryTreePruning btp = new BinaryTreePruning();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        TreeNode res = btp.pruneTree(root);
        System.out.println(res.val);
    }
}
