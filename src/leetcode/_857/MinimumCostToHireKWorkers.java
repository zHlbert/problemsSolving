package leetcode._857;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/
 */
public class MinimumCostToHireKWorkers {

    /**
     * 排序 + 优先队列
     * @param quality
     * @param wage
     * @param k
     * @return
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i] = i;
        }

        // wage[i] / quality[i] 从小到大排序
        Arrays.sort(h, (a, b) -> wage[a] * quality[b] - wage[b] * quality[a]);
        // 保存前 k - 1 个的最小质量的下标
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        double totalq = 0.0;
        double res = 1e9;
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[h[i]];
            pq.offer(quality[h[i]]);
        }

        for (int i = k - 1; i < n; i++) {
            totalq += quality[h[i]];
            pq.offer(quality[h[i]]);
            res = Math.min(res, ((double) wage[h[i]] / quality[h[i]]) * totalq);
            totalq -= pq.poll();
        }
        return res;
    }
}
