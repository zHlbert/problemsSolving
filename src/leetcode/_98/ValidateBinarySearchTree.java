package leetcode._98;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateBinarySearchTree {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
//        return validBST(root);
//        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return validBST1(root);
    }

    private boolean validBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!validBST1(root.left)) {
            return false;
        }

        // 当前节点小于中序遍历的最后一个节点，返回false
        if (root.val <= pre) {
            return false;
        }

        pre = root.val;

        return validBST1(root.right);
    }

    private boolean validBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return validBST(root.left, minValue, root.val) && validBST(root.right, root.val, maxValue);
    }

    public boolean isValidBSTMidAndTraverse(TreeNode root) {
        List<Integer> valList = getMidSeq(root);
        boolean valid = true;
        for (int i = 1; i < valList.size(); i++) {
            if (valList.get(i) <= valList.get(i - 1)) {
                valid = false;
                break;
            }
        }
        return valid;
    }

//    private boolean validBST(TreeNode root) {
//        if (root == null || root.left == null && root.right == null) {
//            return true;
//        }
//        int val = root.val;
//        boolean leftSmall = root.left == null || val > root.left.val;
//        boolean rightBig = root.right == null || val < root.right.val;
//        return leftSmall && rightBig && validBST(root.left) && validBST(root.right);
//    }
//
    private List<Integer> getMidSeq(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> valList = getMidSeq(root.left);
        valList.add(root.val);
        valList.addAll(getMidSeq(root.right));
        return valList;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(6);
//        root.right = new TreeNode(15);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(8);
//        root.right.left = new TreeNode(12);
//        root.right.right = new TreeNode(16);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(v.isValidBST(root));
    }
}
