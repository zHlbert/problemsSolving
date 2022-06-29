package leetcode._958;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 */
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isComplete = true, end = false;
        while (!queue.isEmpty() && isComplete) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                boolean leftNull = cur.left == null;
                boolean rightNull = cur.right == null;
                if (leftNull && rightNull) {
                    end = true;
                    continue;
                }
                if (leftNull) {
                    isComplete = false;
                    break;
                }
                if (end) {
                    isComplete = false;
                    break;
                }
                queue.offer(cur.left);
                if (!rightNull) {
                    queue.offer(cur.right);
                } else {
                    end = true;
                }
            }
        }
        return isComplete;
    }
}
