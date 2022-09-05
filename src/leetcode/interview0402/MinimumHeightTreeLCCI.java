package leetcode.interview0402;

import utils.TreeNode;

public class MinimumHeightTreeLCCI {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildMinBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildMinBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + r >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildMinBST(nums, l, mid - 1);
        root.right = buildMinBST(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        MinimumHeightTreeLCCI mht = new MinimumHeightTreeLCCI();
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = mht.sortedArrayToBST(nums);
        System.out.println(root);
    }
}
