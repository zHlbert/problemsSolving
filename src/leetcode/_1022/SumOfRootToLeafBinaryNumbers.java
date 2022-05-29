package leetcode._1022;

import utils.TreeNode;

/**
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumOfRootToLeafBinaryNumbers {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        backtrack(root, 0);
        return sum;
    }

    private void backtrack(TreeNode root, int curSum) {
        int nSum = (curSum << 1) + root.val;
        if (root.left == null && root.right == null) {
            sum += (curSum << 1) + root.val;
            return;
        }
        if (root.left != null) {
            backtrack(root.left, nSum);
        }
        if (root.right != null) {
            backtrack(root.right, nSum);
        }
    }

    public int sumRootToLeaf1(TreeNode root) {
        return sumTree(root, 0);
    }

    private int sumTree(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = (sum << 1) + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumTree(root.left, sum) + sumTree(root.right, sum);
    }

    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers sr = new SumOfRootToLeafBinaryNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sr.sumRootToLeaf1(root));
    }
}
