package contest.leetcode20220305;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）。
 *
 * 给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边。
 *
 * 请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。
 *
 * 如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> parents = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parents.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            parents.get(edge[1]).add(edge[0]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> parent = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int index = queue.poll();
                if (index != i) {
                    parent.add(index);
                }
                for (Integer p : parents.get(index)) {
                    if (!parent.contains(p)) {
                        queue.offer(p);
                    }
                }
            }
            result.add(parent.stream().sorted().collect(Collectors.toList()));
        }
        return result;
    }
}
