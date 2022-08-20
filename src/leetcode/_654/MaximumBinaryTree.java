package leetcode._654;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        int n = nums.length;
        TreeNode[] trees = new TreeNode[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            trees[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                trees[i].left = trees[stack.pop()];
            }
            if (!stack.isEmpty()) {
                trees[stack.peek()].right = trees[i];
            }
            stack.push(i);
        }
        return trees[stack.peekLast()];
    }
}
