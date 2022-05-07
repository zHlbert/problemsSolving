package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 树工具类
 */
public class TreeUtils {
    /**
     * 打印树后序遍历
     * @param treeNode
     */
    public static void sufPrint(TreeNode treeNode) {
        System.out.println(getSufSeq(treeNode));
    }

    /**
     * 获取树后序遍历数组
     * @param treeNode
     * @return
     */
    public static List<Integer> getSufSeq(TreeNode treeNode) {
        if (treeNode == null) {
            return new ArrayList<>();
        }

        List<Integer> valList = getSufSeq(treeNode.left);
        valList.addAll(getSufSeq(treeNode.right));
        valList.add(treeNode.val);
        return valList;
    }

//    public static TreeNode buildByPreTraverse(Integer[] nums) {
//        int len = nums.length;
//        if (len < 1) {
//            return null;
//        }
//        TreeNode root = new TreeNode(nums[0]);
//        TreeNode curr = root;
//        for (int i = 0; (Math.pow(2, i) - 1) < len; i++) {
//            curr.left = new TreeNode(nums[2 * i + 1]);
//            curr.right = new TreeNode(nums[2 * i + 2]);
//            curr = curr.left;
//        }
//        return root;
//    }
}
