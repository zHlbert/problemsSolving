package leetcode._501;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class FindModeInBinarySearchTree {
    List<Integer> result = new ArrayList<>();
    Integer pre = null;
    int maxCount = 0;
    int count = 0;
    public int[] findMode(TreeNode root) {
        findModeDFS(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void findModeDFS(TreeNode root) {
        if (root == null) {
            return;
        }

        findModeDFS(root.left);

        if (pre == null || root.val != pre) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        } else if (count == maxCount) {
            result.add(root.val);
        }

        pre = root.val;
        findModeDFS(root.right);
    }
}
