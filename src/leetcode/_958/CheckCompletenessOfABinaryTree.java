package leetcode._958;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
 */
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTreeBFS(TreeNode root) {
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

    public boolean isCompleteTreeBFS1(TreeNode root) {
        List<ANode> nodes = new ArrayList<>();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode aNode = nodes.get(i++);
            TreeNode node = aNode.node;
            if (node != null) {
                nodes.add(new ANode(node.left, aNode.code * 2));
                nodes.add(new ANode(node.right, aNode.code * 2 + 1));
            }
        }
        return nodes.size() == nodes.get(i - 1).code;
    }

    public static void main(String[] args) {
        CheckCompletenessOfABinaryTree cc = new CheckCompletenessOfABinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(cc.isCompleteTreeBFS1(root));
    }
}

class ANode {
    public int code;
    public TreeNode node;

    public ANode(TreeNode node, int val) {
        this.node = node;
        this.code = val;
    }
}
