package interview_experience;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层序遍历，返回从底向上
 */
public class BinaryTreeReverseLevelTraverse {
    public List<Integer> reverseLevelTraverse(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayDeque<List<Integer>> stack = new ArrayDeque<>();


        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            stack.push(level);
        }

        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            List<Integer> levelList = stack.pop();
            res.addAll(levelList);
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeReverseLevelTraverse btt = new BinaryTreeReverseLevelTraverse();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(btt.reverseLevelTraverse(root));
    }
}
