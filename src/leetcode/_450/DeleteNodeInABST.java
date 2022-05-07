package leetcode._450;

import utils.TreeNode;
import utils.TreeUtils;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Follow up: Can you solve it with time complexity O(height of tree)?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteNodeInABST {
//    public TreeNode deleteNode(TreeNode root, int key) {
//        TreeNode curr = root;
//        TreeNode[] nodes = findNode(root, key);
//        TreeNode pre = nodes[0];
//        TreeNode toBeRemoved = nodes[1];
//        if (toBeRemoved != null) {
//            if (pre != null) {
//
//            }
//        }
//        return root;
//    }

//    private TreeNode[] findNode(TreeNode curr, int key) {
//        TreeNode pre = null;
//        while (curr != null) {
//            int val = curr.val;
//            if (val == key) {
//                return new TreeNode[] {pre, curr};
//            }
//            pre = curr;
//            if (val < key) {
//                curr = curr.right;
//            } else {
//                curr = curr.left;
//            }
//        }
//        return new TreeNode[] {pre, curr};
//    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        // key值在右子树，在右子树删除
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            // 要删除当前节点
            // 若为叶子节点，则直接删除
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                // 右子树非空，找到后继节点，当前值设为后继节点，在右子树删除该后继节点
                root.val = getSuccessorValue(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // 左子树非空，找到前驱节点，当前值设为前驱节点，在左子树删除该前驱节点
                root.val = getPredecessorValue(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /**
     * BST中序遍历中当前节点的前一个节点的值
     * @param curr
     * @return
     */
    public int getPredecessorValue(TreeNode curr) {
        TreeNode pre = curr.left;
        while (pre.right != null) {
            pre = pre.right;
        }
        return pre.val;
    }

    /**
     * BST中序遍历中当前节点的后一个节点的值
     * @param curr
     * @return
     */
    public int getSuccessorValue(TreeNode curr) {
        TreeNode pre = curr.right;
        while (pre.left != null) {
            pre = pre.left;
        }
        return pre.val;
    }

    public static void main(String[] args) {
        DeleteNodeInABST d = new DeleteNodeInABST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        TreeNode root1 = d.deleteNode(root, 3);
        TreeUtils.sufPrint(root1);
    }
}
