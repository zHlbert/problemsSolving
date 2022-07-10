package contest.leetcode20220709;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumSumOfSquaredDifference {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }
        Arrays.sort(diff);
        int k = k1 + k2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
        }
        if (sum <= k)  {
            return 0;
        }
//        int[] diffCnt = new int[100005];
//        for (int i = 0; i < n; i++) {
//            diffCnt[diff[i]]++;
//        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int d : diff) {
            pq.add(d);
        }
        while (k > 0) {
            int cur = pq.poll();
            cur--;
            k--;
            if (cur > 0) {
                pq.offer(cur);
            }
        }
        return 0;
    }
}
