package leetcode._1145;

import utils.TreeNode;

public class BinaryTreeColoringGame {
    /**
     * dfs
     * @param root
     * @param n
     * @param x
     * @return
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node = findX(root, x);
        int left = count(node.left);
        int right = count(node.right);
        int remain = n - 1 - left - right;
        return (left << 1) > n || (right << 1) > n || (remain << 1) > n;
    }

    private int count(TreeNode node) {
        return node == null ? 0 : 1 + count(node.left) + count(node.right);
    }

    private TreeNode findX(TreeNode node, int x) {
        if (node == null || node.val == x) return node;
        TreeNode res = findX(node.left, x);
        if (res != null) return res;
        return findX(node.right, x);
    }
}
