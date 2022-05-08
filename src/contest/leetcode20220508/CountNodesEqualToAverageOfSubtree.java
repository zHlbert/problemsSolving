package contest.leetcode20220508;

import utils.TreeNode;

public class CountNodesEqualToAverageOfSubtree {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        countAvgOfSubTree(root);
        return res;
    }

    /**
     *
     * @param root
     * @return {sum, count}
     */
    private int[] countAvgOfSubTree(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = countAvgOfSubTree(root.left);
        int[] right = countAvgOfSubTree(root.right);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        if (root.val == sum / count) {
            res++;
        }
        return new int[] {sum, count};
    }
}
