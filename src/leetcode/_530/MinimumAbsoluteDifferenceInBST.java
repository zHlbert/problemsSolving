package leetcode._530;

import utils.TreeNode;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBST {
    int minDiff = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        getMinAbsDiff(root);
        return minDiff;
    }

    private void getMinAbsDiff(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinimumDifference(root.left);
        minDiff = Math.min(minDiff, Math.abs(root.val - pre));
        pre = root.val;
        getMinimumDifference(root.right);
    }
}
