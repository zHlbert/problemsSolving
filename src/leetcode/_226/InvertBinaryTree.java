package leetcode._226;

import utils.TreeNode;
import utils.TreeUtils;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(TreeUtils.getSufSeq(root));
        InvertBinaryTree invert = new InvertBinaryTree();
        invert.invertTree(root);
        System.out.println(TreeUtils.getSufSeq(root));
    }
}
