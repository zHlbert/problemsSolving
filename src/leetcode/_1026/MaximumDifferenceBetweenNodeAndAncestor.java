package leetcode._1026;

import utils.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
//    int res = 0;
//    public int maxAncestorDiff(TreeNode root) {
//        getRes(root);
//        return res;
//    }
//
//    private void getRes(TreeNode root) {
//        if (root == null) return;
//        int val = root.val;
//        if (root.left != null) {
//            int[] mm = minMax(root.left);
//            res = Math.max(Math.abs(val - mm[0]), Math.abs(val - mm[1]));
//        }
//        if (root.right != null) {
//            int[] mm = minMax(root.right);
//            res = Math.max(Math.abs(val - mm[0]), Math.abs(val - mm[1]));
//        }
//    }
//
//    private int[] minMax(TreeNode node) {
//        if (node == null) return new int[2];
//        int[] ret = new int[] {node.val, node.val};
//        if (node.left != null) {
//            int[] leftVal = minMax(node.left);
//            ret[0] = Math.min(ret[0], leftVal[0]);
//            ret[1] = Math.max(ret[1], leftVal[1]);
//        }
//        if (node.right != null) {
//            int[] rightVal = minMax(node.right);
//            ret[0] = Math.min(ret[0], rightVal[0]);
//            ret[1] = Math.max(ret[1], rightVal[1]);
//        }
//        return ret;
//    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return 0;
        int diff = Math.max(Math.abs(root.val - mn), Math.abs(root.val - mx));
        mn = Math.min(mn, root.val);
        mx = Math.max(mx, root.val);
        diff = Math.max(diff, dfs(root.left, mn, mx));
        diff = Math.max(diff, dfs(root.right, mn, mx));
        return diff;
    }
}
