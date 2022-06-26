package contest.leetcode20220626;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-score-after-removals-on-a-tree/
 */
public class MinimumScoreAfterRemovalsOnATree {
    int res = (int) 2e9;
    // s[i] 表示 以 i 为根节点 的子树 异或和
    int[] s;
    // 节点 对应的 后继节点
    List<Integer>[] nes;
    // 所有节点的异或和
    int all = 0;
    int[] nums;

    public int minimumScore(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        nes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nes[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            nes[edge[0]].add(edge[1]);
            nes[edge[1]].add(edge[0]);
        }

        s = new int[n];

        for (int num : nums) {
            all ^= num;
        }

        for (int i = 0; i < n; i++) {
            dfs(i, -1);
            for (int ne : nes[i]) {
                getRes(ne, i, s[ne]);
            }
        }

        return res;
    }

    /**
     * 计算 min(最大异或 - 最小异或)
     * @param node
     * @param pre
     * @param sum
     */
    private void getRes(int node, int pre, int sum) {
        for (int ne : nes[node]) {
            if (ne != pre) {
                // 计算三个子树的异或和
                int s1 = all ^ sum, s2 = sum ^ s[ne], s3 = s[ne];
                res = Math.min(res, Math.max(s1, Math.max(s2, s3)) - Math.min(s1, Math.min(s2, s3)));
                getRes(ne, node, sum);
            }
        }
    }

    /**
     * 计算以node为根节点 的子树 异或和
     * @param node
     * @param pre
     */
    private void dfs(int node, int pre) {
        s[node] = nums[node];
        for (int ne : nes[node]) {
            if (ne != pre) {
                dfs(ne, node);
                s[node] ^= s[ne];
            }
        }
    }
}
