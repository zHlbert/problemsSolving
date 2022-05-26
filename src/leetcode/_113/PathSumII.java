package leetcode._113;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumII {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtrack(root, targetSum, new ArrayList<>());
        return res;
    }

    private void backtrack(TreeNode root, int targetSum, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (root.left != null) {
            backtrack(root.left, targetSum - root.val, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            backtrack(root.right, targetSum - root.val, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        PathSumII ps2 = new PathSumII();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(ps2.pathSum(root, 22));
    }
}
