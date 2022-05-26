package leetcode._513;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return ans;
    }

    int maxD = 0;
    int res = 0;
    public int findBottomLeftValueDFS(TreeNode root) {
        backtrack(root, 1);
        return res;
    }

    private void backtrack(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth > maxD) {
                maxD = depth;
                res = root.val;
            }
        } else {
            backtrack(root.left, depth + 1);
            backtrack(root.right, depth + 1);
        }
    }
}
