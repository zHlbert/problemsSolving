package leetcode._145;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postTraversal(root);
        return res;
    }

    private void postTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal btp = new BinaryTreePostorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(btp.postorderTraversal(root));
    }
}
