package leetcode._968;

import utils.TreeNode;

/**
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode.cn/problems/binary-tree-cameras/
 */
public class BinaryTreeCameras {
    public int minCameraCover(TreeNode root) {
        int[] minCamera = minCameraDP(root);
        return minCamera[1];
    }

    /**
     * 树形动态规划
     * @param root
     * @return int[3] c c[0] 包含root的最少相机数，c[1] 最少相机数（不一定包含root）, c[2] 监控 root 的两子树所需相机数
     */
    private int[] minCameraDP(TreeNode root) {
        if (root == null) {
            return new int[] {1000, 0, 0};
        }
        int[] lCam = minCameraDP(root.left);
        int[] rCam = minCameraDP(root.right);
        int a = lCam[2] + rCam[2] + 1;
        int b = Math.min(a, Math.min(lCam[0] + rCam[1], lCam[1] + rCam[0]));
        int c = Math.min(a, lCam[1] + rCam[1]);
        return new int[] {a, b, c};
    }
}
