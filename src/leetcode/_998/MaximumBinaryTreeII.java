package leetcode._998;

import utils.TreeNode;

/**
 * https://leetcode.cn/problems/maximum-binary-tree-ii/
 */
public class MaximumBinaryTreeII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        if (val > root.val) {
            node.left = root;
            return node;
        }
        if (root.right == null) {
            root.right = node;
        } else {
            if (val < root.right.val) {
                insertIntoMaxTree(root.right, val);
            } else {
                node.left = root.right;
                root.right = node;
            }
        }
        return root;
    }
}
