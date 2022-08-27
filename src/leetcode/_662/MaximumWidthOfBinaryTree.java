package leetcode._662;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Deque<Integer> noq = new ArrayDeque<>();
        noq.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int st = 0, ed = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int no = noq.poll();
                if (i == 0) {
                    st = no;
                }
                if (i == size - 1) {
                    ed = no;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    noq.offer((no << 1));
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    noq.offer(((no << 1) + 1));
                }
            }
            res = Math.max(res, ed - st + 1);
        }
        return res;
    }
}
