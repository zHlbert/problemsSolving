package contest.leetcode20210711;

import utils.TreeNode;

import java.util.List;

/**
 * You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array trees (0-indexed). Each BST in trees has at most 3 nodes, and no two roots have the same value. In one operation, you can:
 *
 * Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the root value of trees[j].
 * Replace the leaf node in trees[i] with trees[j].
 * Remove trees[j] from trees.
 * Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1 operations, or null if it is impossible to create a valid BST.
 *
 * A BST (binary search tree) is a binary tree where each node satisfies the following property:
 *
 * Every node in the node's left subtree has a value strictly less than the node's value.
 * Every node in the node's right subtree has a value strictly greater than the node's value.
 * A leaf is a node that has no children.
 */
public class MergeBSTsToCreateSingleBST {
    public TreeNode canMerge(List<TreeNode> trees) {
        int n = trees.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int s = combineTree(trees.get(i), trees.get(j));
            }
        }
        return null;
    }

    private int combineTree(TreeNode t1, TreeNode t2) {
        TreeNode p;
        if (t1.val < t2.val) {
            p = t2;
//            TreeNode res = search()
        }
        return 0;
    }
}
