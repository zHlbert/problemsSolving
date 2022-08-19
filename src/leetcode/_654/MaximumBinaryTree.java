package leetcode._654;

import utils.TreeNode;

public class MaximumBinaryTree {
    /**
     * 递归
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxBinTree(nums, 0, nums.length - 1);
    }

    public TreeNode maxBinTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mi = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] > nums[mi]) {
                mi = i;
            }
        }
        TreeNode node = new TreeNode(nums[mi]);
        node.left = maxBinTree(nums, begin, mi - 1);
        node.right = maxBinTree(nums, mi + 1, end);
        return node;
    }
}
