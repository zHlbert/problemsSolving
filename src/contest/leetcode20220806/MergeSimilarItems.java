package contest.leetcode20220806;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> vwMap = new TreeMap<>();
        for (int[] item : items1) {
            vwMap.put(item[0], item[1]);
        }

        for (int[] item : items2) {
            Integer weight = vwMap.getOrDefault(item[0], 0);
            vwMap.put(item[0], weight + item[1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : vwMap.entrySet()) {
            List<Integer> item = new ArrayList<>();
            item.add(entry.getKey());
            item.add(entry.getValue());
            res.add(item);
        }
        return res;
    }
}
