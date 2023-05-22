package leetcode._1080;

import utils.TreeNode;

public class InsufficientNodesInRootToLeafPaths {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean sufficient = sufficientLeaf(root, 0, limit);
        return sufficient ? root : null;
    }

    private boolean sufficientLeaf(TreeNode node, int sum, int limit) {
        if (node == null) return false;
        if (node.left == null && node.right == null)
            return node.val + sum >= limit;
        boolean sufficientLeft = sufficientLeaf(node.left, sum + node.val, limit);
        boolean sufficientRight = sufficientLeaf(node.right, sum + node.val, limit);
        if (!sufficientLeft) node.left = null;
        if (!sufficientRight) node.right = null;
        return sufficientLeft || sufficientRight;
    }
}
