package leetcode._297;

import utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(1);
        String encodeStr = c.serialize(root);
        System.out.println(encodeStr);
        TreeNode newRoot = c.deserialize(encodeStr);
        System.out.println(c.serialize(newRoot));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return preorder(root, sb).toString();
    }

    private StringBuilder preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X,");
        } else {
            sb.append(root.val).append(",");
            sb = preorder(root.left, sb);
            sb = preorder(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] treeArr = data.split(",");
        List<String> treeList = new LinkedList<>(Arrays.asList(treeArr));
        return construct(treeList);
    }

    private TreeNode construct(List<String> treeList) {
        String nodeStr = treeList.get(0);
        if (nodeStr.equals("X")) {
            treeList.remove(0);
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(nodeStr));
        treeList.remove(0);
        cur.left = construct(treeList);
        cur.right = construct(treeList);
        return cur;
    }
}
