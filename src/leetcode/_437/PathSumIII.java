package leetcode._437;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum-iii/
 */
public class PathSumIII {
    int count = 0;
    List<List<Integer>> res = new ArrayList<>();
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return count;
//        }
//        backtrack(root, targetSum, new ArrayList<>());
//        return count;
//    }
//
//    private void backtrack(TreeNode root, int targetSum, List<Integer> path) {
//        if (root == null) {
//            return;
//        }
//        if (targetSum == root.val) {
//            count++;
//            path.add(root.val);
//            res.add(new ArrayList<>(path));
//            path.remove(path.size() - 1);
////            System.out.println(root.val);
//            return;
//        }
//            path.add(root.val);
//            backtrack(root.left, targetSum - root.val, path);
//            path.remove(path.size() - 1);
////            backtrack(root.left, targetSum, path);
//            path.add(root.val);
//            backtrack(root.right, targetSum - root.val, path);
//            path.remove(path.size() - 1);
////            backtrack(root.right, targetSum, path);
//    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSumBackTrack(root, targetSum, false);
    }

    private int pathSumBackTrack(TreeNode root, int targetSum, boolean hasPre) {
        if (root == null) {
            return 0;
        }
        return pathSumBackTrack(root.left, targetSum - root.val, true)
                + pathSumBackTrack(root.right, targetSum - root.val, true)
                + (hasPre ? 0
                    : pathSumBackTrack(root.left, targetSum, false)
                        + pathSumBackTrack(root.right, targetSum, false))
                + (targetSum == root.val ? 1 : 0);
    }

    public static void main(String[] args) {
        PathSumIII ps3 = new PathSumIII();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        System.out.println(ps3.pathSum(root, targetSum));
//        System.out.println(ps3.res);
    }
}
