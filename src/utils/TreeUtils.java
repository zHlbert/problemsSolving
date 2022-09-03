package utils;

import java.util.*;

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

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return preorder(root, sb).toString();
    }

    private static StringBuilder preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X,");
        } else {
            sb.append(root.val).append(",");
            sb = preorder(root.left, sb);
            sb = preorder(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] treeArr = data.split(",");
        List<String> treeList = new LinkedList<>(Arrays.asList(treeArr));
        return construct(treeList);
    }

    private static TreeNode construct(List<String> treeList) {
        String nodeStr = treeList.get(0);
        if (nodeStr.equals("X")) {
            treeList.remove(0);
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(nodeStr));
        treeList.remove(0);
        cur.left = construct(treeList);
        cur.right = construct(treeList);
        return cur;
    }

    public static String serializeByLevel(TreeNode root) {
        List<String> treeList = serializeByLevelToList(root);
        return "[" + String.join(",", treeList) + "]";
    }

    private static List<String> serializeByLevelToList(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node != null ? String.valueOf(node.val) : "X");
                if (node == null) {
                    continue;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return list;
    }
}
