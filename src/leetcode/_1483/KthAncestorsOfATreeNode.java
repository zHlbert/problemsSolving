package leetcode._1483;

import java.util.Arrays;

public class KthAncestorsOfATreeNode {

}

class TreeAncestor {

    static final int LOG = 16;
    int[][] ancestors;

    /**
     * 倍增
     * https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/solution/shu-jie-dian-de-di-k-ge-zu-xian-by-leetc-hdxd/
     * @param n
     * @param parent
     */
    public TreeAncestor(int n, int[] parent) {
//        定义 ancestors[i][j] 表示节点 i 的第 2 ^ j 个祖先
        ancestors = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ancestors[i], -1);
        }
        for (int i = 0; i < n; i++) {
            ancestors[i][0] = parent[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (ancestors[i][j - 1] != -1) {
                    ancestors[i][j] = ancestors[ancestors[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < LOG; i++) {
            if (((k >> i) & 1) != 0) {
                node = ancestors[node][i];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}