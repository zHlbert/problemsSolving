package leetcode._655;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/print-binary-tree/
 */
public class PrintBinaryTree {
    /**
     * DFS
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        int h = getDepth(root);
        int w = (1 << h) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < w; j++) {
                row.add("");
            }
            res.add(row);
        }
        dfs(res, root, 0, (w - 1) / 2, h - 1);
        return res;
    }

    private void dfs(List<List<String>> res, TreeNode root, int r, int c, int h) {
        res.get(r).set(c, String.valueOf(root.val));
        if (root.left != null) {
            dfs(res, root.left, r + 1, c - (1 << (h - r - 1)), h);
        }
        if (root.right != null) {
            dfs(res, root.right, r + 1, c + (1 << (h - r - 1)), h);
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
