package leetcode._1110;

import utils.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest {
    Set<Integer> set = new HashSet<>();
    List<TreeNode> roots = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        dfs(root, true);
        return roots;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot) {
        if (node == null) return null;
        boolean deleted = set.contains(node.val);
        node.left = dfs(node.left, deleted);
        node.right = dfs(node.right, deleted);
        if (deleted) return null;
        if (isRoot) roots.add(node);
        return node;
    }

//    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//        set = new HashSet<>();
//        for (int i : to_delete) {
//            set.add(i);
//        }
//        return dfs(root);
//    }
//
//    private List<TreeNode> dfs(TreeNode root) {
//        List<TreeNode> res = new ArrayList<>();
//        if (root == null) return res;
//        if (root.left != null) {
//            if (set.contains(root.left.val)) {
//                res.addAll(dfs(root.left.left));
//                res.addAll(dfs(root.left.right));
//                root.left = null;
//            } else res.addAll(dfs(root.left));
//        }
//        if (root.right != null) {
//            if (set.contains(root.right.val)) {
//                res.addAll(dfs(root.right.left));
//                res.addAll(dfs(root.right.right));
//                root.right = null;
//            } else res.addAll(dfs(root.right));
//        }
//        res.add(root);
//        return res;
//    }

    public static void main(String[] args) {
        DeleteNodesAndReturnForest dn = new DeleteNodesAndReturnForest();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        List<TreeNode> res = dn.delNodes(root, new int[] {3});
        System.out.println(res);
    }
}
