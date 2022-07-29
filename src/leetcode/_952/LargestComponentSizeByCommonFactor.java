package leetcode._952;

/**
 * https://leetcode.cn/problems/largest-component-size-by-common-factor/
 */
public class LargestComponentSizeByCommonFactor {
    /**
     * 并查集
     * @param nums
     * @return
     */
    public int largestComponentSize(int[] nums) {
        int maxn = 0;
        for (int num : nums) {
            maxn = Math.max(maxn, num);
        }
        UnionFind uf = new UnionFind(maxn + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] cnts = new int[maxn + 1];
        int res = 0;
        for (int num : nums) {
            int root = uf.find(num);
            cnts[root]++;
            res = Math.max(res, cnts[root]);
        }
        return res;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            // 按秩合并
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rooty] > rank[rootx]) {
                parent[rootx] = rooty;
            } else {
                parent[rootx] = rooty;
                rank[rooty]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
