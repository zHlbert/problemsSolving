package leetcode._347;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>(nums.length);
        for (int num : nums) {
            int cnt = cntMap.getOrDefault(num, 0);
            cntMap.put(num, cnt + 1);
        }
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparing(a -> a[1], Comparator.reverseOrder()));
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            pQueue.add(new int[] {entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pQueue.poll()[0];
        }
        return res;
    }

    public int[] topKFrequentMinHeap(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>(nums.length);
        for (int num : nums) {
            int cnt = cntMap.getOrDefault(num, 0);
            cntMap.put(num, cnt + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            pQueue.offer(entry);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pQueue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements tkf = new TopKFrequentElements();
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        ArrayUtils.printArray(tkf.topKFrequent(nums, k));
    }
}
