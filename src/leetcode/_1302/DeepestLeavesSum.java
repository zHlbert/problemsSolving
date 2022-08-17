package leetcode._1302;

import utils.TreeNode;

/**
 * https://leetcode.cn/problems/deepest-leaves-sum/
 */
public class DeepestLeavesSum {
    int sum = 0, m = 0;
    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 1);
        return sum;
    }

    private void deepestLeavesSum (TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > m) {
            m = level;
            sum = root.val;
        } else if (level == m) {
            sum += root.val;
        }
        deepestLeavesSum(root.left, level + 1);
        deepestLeavesSum(root.right, level + 1);
    }
}
