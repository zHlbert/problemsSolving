package leetcode._669;

import utils.TreeNode;
import utils.TreeUtils;

/**
 *
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return root.right != null ? trimBST(root.right, low, high) : null;
        } else if (root.val > high) {
            return root.left != null ? trimBST(root.left, low, high) : null;
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }

    public static void main(String[] args) {
        TrimBST trim = new TrimBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        TreeNode treeNode = trim.trimBST(root, 1, 3);
        System.out.println(TreeUtils.serializeByLevel(treeNode));
    }
}
