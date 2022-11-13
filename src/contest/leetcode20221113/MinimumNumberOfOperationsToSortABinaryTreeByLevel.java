package contest.leetcode20221113;

import utils.ListNode;
import utils.TreeNode;

import java.util.*;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            int[] a = new int[sz], b = new int[sz];
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                a[i] = b[i] = node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            Arrays.sort(b);
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < sz; i++) {
                m.put(b[i], i);
            }

            for (int i = 0; i < sz; i++) {
                while (a[i] != b[i]) {
                    swap(a, i, m.get(a[i]));
                    res++;
                }
            }
        }

        return res;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // TODO: 2022/11/13 循环节

    // TODO: 2022/11/13 并查集

    public static void main(String[] args) {
        MinimumNumberOfOperationsToSortABinaryTreeByLevel mn = new MinimumNumberOfOperationsToSortABinaryTreeByLevel();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(mn.minimumOperations(root));
    }
}
