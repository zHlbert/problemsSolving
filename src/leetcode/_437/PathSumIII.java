package leetcode._437;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 前缀和对应的数量
    Map<Integer, Integer> preSumCount;
    int targetSum;
    public int pathSum1(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        preSumCount = new HashMap<>();
        // 表示前缀和为0的节点为空，有一个空。否则若curSum = targetSum，将错过从root到i这条路径
        preSumCount.put(0, 1);
        return preSumBacktrack(root, 0);
    }

    private int preSumBacktrack(TreeNode root, int curSum) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        // sum(i,j) = preSum(i) - preSum(j) = targetSum
        // curSum为根节点到当前节点的和
        int cnt = preSumCount.getOrDefault(curSum - targetSum, 0);

        preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) + 1);
        cnt += preSumBacktrack(root.left, curSum);
        cnt += preSumBacktrack(root.right, curSum);
        preSumCount.put(curSum, preSumCount.get(curSum) - 1);
        return cnt;
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
        System.out.println(ps3.pathSum1(root, targetSum));
//        System.out.println(ps3.res);
    }
}
