package leetcode._687;

import utils.TreeNode;
import utils.TreeUtils;

public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = longestUniPath(root);
        return Math.max(Math.max(res[0], res[1]), res[2]) - 1;
    }

    private int[] longestUniPath(TreeNode root) {

        int[] ll = new int[3], rl = new int[3];
        int cRoot = 1, cRootSingle = 1;
        if (root.left != null) {
            ll = longestUniPath(root.left);
            if (root.val == root.left.val) {
                cRoot += ll[1];
                cRootSingle = Math.max(cRootSingle, ll[1] + 1);
            }
        }
        if (root.right != null) {
            rl = longestUniPath(root.right);
            if (root.val == root.right.val) {
                cRoot += rl[1];
                cRootSingle = Math.max(cRootSingle, rl[1] + 1);
            }
        }

        return new int[] {cRoot, cRootSingle, Math.max(Math.max(ll[0], ll[2]), Math.max(rl[0], rl[2]))};
    }

    int res = 0;

    public int longestUnivaluePath1(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int lPath = root.left != null && root.left.val == root.val ? l + 1 : 0;
        int rPath = root.right != null && root.right.val == root.val ? r + 1 : 0;
        res = Math.max(res, lPath + rPath);
        return Math.max(lPath, rPath);
    }

    public static void main(String[] args) {
        LongestUnivaluePath lup = new LongestUnivaluePath();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        String treeStr = TreeUtils.serializeByLevel(root);
        System.out.println(treeStr);
        System.out.println(lup.longestUnivaluePath1(root));
    }
}
