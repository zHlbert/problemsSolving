package leetcode.lcp33;

import java.util.PriorityQueue;

public class SaveWater {
    public int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = bucket.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (bucket[i] == 0 && vat[i] != 0) {
                bucket[i]++;
                cnt++;
            }
            if (vat[i] > 0)
                pq.offer(new int[] {(vat[i] + bucket[i] - 1) / bucket[i], i});
        }
        if (pq.isEmpty()) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        while (cnt < res) {
            int[] x = pq.poll();
            int v = x[0], i = x[1];
            res = Math.min(res, cnt + v);
            if (v == 1) break;
            int t = (vat[i] + v - 2) / (v - 1);
            cnt += t - bucket[i];
            bucket[i] = t;
            pq.offer(new int[] {(vat[i] + bucket[i] - 1) / bucket[i], i});
        }
        return res;
    }
}
