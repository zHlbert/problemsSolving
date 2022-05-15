package leetcode.interview0406;

import utils.TreeNode;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
 *
 * Return null if there's no "next" node for the given node.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/successor-lcci/
 */
public class SuccessorLCCI {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode left = inorderSuccessor(root.left, p);
        if (left == null) {
            return root;
        }
        return left.val < root.val ? left : root;
    }

    public static void main(String[] args) {
        SuccessorLCCI successor = new SuccessorLCCI();
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        TreeNode res = successor.inorderSuccessor(root, new TreeNode(7));
        System.out.println(res == null ? "null": res.val);
    }
}
