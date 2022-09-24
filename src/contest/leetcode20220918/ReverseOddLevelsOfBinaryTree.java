package contest.leetcode20220918;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean odd = false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (odd) {
                    list.add(node);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (!list.isEmpty()) {
                reverseNodes(list);
            }
            odd = !odd;
        }
        return root;
    }

    private void reverseNodes(List<TreeNode> list) {
        int n = list.size();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = list.get(i).val;
            list.get(i).val = list.get(j).val;
            list.get(j).val = tmp;
        }
    }
}
