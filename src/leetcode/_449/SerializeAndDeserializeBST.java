package leetcode._449;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class SerializeAndDeserializeBST {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(22);
        String encodedStr = codec.serialize(root);
        System.out.println(encodedStr);

        TreeNode newRoot = codec.deserialize(encodedStr);
        System.out.println(newRoot);
        System.out.println(codec.serialize(newRoot));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        String s = res.toString();
        return s.substring(1, s.length() - 1);
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(", ");
        Deque<Integer> queue = new ArrayDeque<>(arr.length);
        for (String s : arr) {
            queue.offer(Integer.parseInt(s));
        }

        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, queue);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> queue) {
        if (queue.isEmpty() || queue.peek() < lower || queue.peek() > upper) {
            return null;
        }
        int curVal = queue.poll();
        TreeNode root = new TreeNode(curVal);
        root.left = construct(lower, curVal, queue);
        root.right = construct(curVal, upper, queue);
        return root;
    }
}
