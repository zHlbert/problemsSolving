package leetcode._538;

import utils.TreeNode;

/**
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */
public class ConvertBSTToGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }

    public TreeNode convertBST1(TreeNode root) {
        dfs1(root, 0);
        return root;
    }

    private int dfs1(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        root.val += dfs1(root.right, sum);
        return dfs1(root.left, root.val);
    }

    public static void main(String[] args) {
        ConvertBSTToGreaterTree cg = new ConvertBSTToGreaterTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        TreeNode treeNode = cg.convertBST1(root);
        System.out.println(treeNode.val);
    }
}
