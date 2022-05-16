package leetcode._173;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

}

class BSTIterator {
    List<Integer> inorderList;
    int idx;

    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<>();
        inorder(root);
        idx = 0;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }

    public int next() {
        int curVal = inorderList.get(idx);
        idx++;
        return curVal;
    }

    public boolean hasNext() {
        return idx < inorderList.size();
    }
}
