package leetcode._257;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        backtrack(root, new StringBuilder(String.valueOf(root.val)));
        return res;
    }

    private void backtrack(TreeNode root, StringBuilder path) {
        if (root.left == null && root.right == null) {
            res.add(path.toString());
            return;
        }
        StringBuilder tmp;
        if (root.left != null) {
            tmp = new StringBuilder(path);
            backtrack(root.left, tmp.append("->").append(root.left.val));
        }
        if (root.right != null) {
            tmp = new StringBuilder(path);
            backtrack(root.right, tmp.append("->").append(root.right.val));
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(btp.binaryTreePaths(root));
    }
}
