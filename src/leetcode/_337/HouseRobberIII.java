package leetcode._337;

import utils.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    // ⻓度为2的数组，0：不偷，1：偷
    private int[] robTree(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        // 不偷当前节点，选出左右子树偷与不偷的最大值相加
        int var0 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点，不偷左右孩子的数值相加
        int var1 = root.val + left[0] + right[0];
        return new int[] {var0, var1};
    }
}

