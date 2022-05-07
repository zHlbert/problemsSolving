package leetcode._107;

import utils.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<List<Integer>> deque = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }
            deque.push(new ArrayList<>(levelList));
        }
        while (!deque.isEmpty()) {
            ans.add(deque.pop());
        }
        return ans;
    }
}
