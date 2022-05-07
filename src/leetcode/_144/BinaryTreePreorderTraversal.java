package leetcode._144;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePreorderTraversal {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preTraversal(root);
        return result;
    }

    private void preTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preTraversal(root.left);
        preTraversal(root.right);
    }
}
