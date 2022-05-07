package leetcode._1305;

import utils.ArrayUtils;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        getElements(root1, res1);
        getElements(root2, res2);
        int s1 = res1.size();
        int s2 = res2.size();
        List<Integer> res = new ArrayList<>(s1 + s2);
        int i1 = 0, i2 = 0;
        while (i1 < s1 || i2 < s2) {
            if (i1 == s1) {
                res.addAll(res2.subList(i2, s2));
                break;
            } else if (i2 == s2) {
                res.addAll(res1.subList(i1, s1));
                break;
            }
            if (res1.get(i1) < res2.get(i2)) {
                res.add(res1.get(i1++));
            } else {
                res.add(res2.get(i2++));
            }

        }

        return res;
    }

    private void getElements(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        getElements(root.left, res);
        res.add(root.val);
        getElements(root.right, res);
    }

    public static void main(String[] args) {
        AllElementsInTwoBinarySearchTrees ae = new AllElementsInTwoBinarySearchTrees();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        System.out.println(ae.getAllElements(root1, root2));
    }
}
