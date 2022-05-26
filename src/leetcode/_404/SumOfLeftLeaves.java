package leetcode._404;

import utils.TreeNode;

/**
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
    TreeNode pre;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return pre != null && pre.left == root ? root.val : 0;
        }
        int sum = 0;
        if (root.left != null) {
            pre = root;
            sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            pre = root;
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftVal = (root.left != null && root.left.left == null && root.left.right == null) ? root.left.val : 0;
        return leftVal
                + sumOfLeftLeaves1(root.left)
                + sumOfLeftLeaves1(root.right);
    }

    public static void main(String[] args) {
        SumOfLeftLeaves sll = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sll.sumOfLeftLeaves(root));
    }
}
