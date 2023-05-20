package leetcode._1373;

import utils.TreeNode;

public class MaximumSumBSTInBinaryTree {
    private int res;

    /**
     * https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/solution/hou-xu-bian-li-pythonjavacgo-by-endlessc-gll3/
     * @param root
     * @return
     */
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int x = node.val;
        // 不是二叉搜索树
        if (x <= left[1] || x >= right[0])  {
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int s = left[2] + right[2] + x;
        res = Math.max(res, s);
        return new int[] {Math.min(left[0], x), Math.max(right[1], x), s};
    }
}
