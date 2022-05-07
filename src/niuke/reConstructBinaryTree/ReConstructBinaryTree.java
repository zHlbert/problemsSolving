package niuke.reConstructBinaryTree;

import utils.TreeNode;
import utils.TreeUtils;

/**
 * 通过前序遍历与后序遍历重建树
 * 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 */
public class ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] preArr = {1,2,4,7,3,5,6,8};
        int[] inArr = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(preArr, inArr);
        TreeUtils.sufPrint(treeNode);
    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }


    private static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode rootNode = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                rootNode.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                rootNode.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return rootNode;
    }
}
