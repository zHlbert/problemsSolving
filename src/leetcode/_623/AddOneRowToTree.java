package leetcode._623;

import utils.TreeNode;

/**
 * https://leetcode.cn/problems/add-one-row-to-tree/
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        return addOneRow(root, val, depth, 1);
    }

    private TreeNode addOneRow(TreeNode root, int val, int depth, int cur) {
        if (root == null) {
            return null;
        }
        if (cur + 1 == depth) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth, cur + 1);
            root.right = addOneRow(root.right, val, depth, cur + 1);
        }
        return root;
    }
}
