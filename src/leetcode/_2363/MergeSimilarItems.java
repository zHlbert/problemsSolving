package leetcode._2363;

import java.util.*;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> weights = new HashMap<>();
        for (int[] item : items1) {
            int weight = weights.getOrDefault(item[0], 0);
            weights.put(item[0], weight + item[1]);
        }
        for (int[] item : items2) {
            int weight = weights.getOrDefault(item[0], 0);
            weights.put(item[0], weight + item[1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(weights.keySet());
        keys.sort(Comparator.comparing(a -> a));
        for (Integer key : keys) {
            List<Integer> valueWeights = new ArrayList<>();
            valueWeights.add(key);
            valueWeights.add(weights.get(key));
            res.add(valueWeights);
        }
        return res;
    }

    public List<List<Integer>> mergeSimilarItems1(int[][] items1, int[][] items2) {
        int[] weights = new int[1010];
        for (int[] item : items1)
            weights[item[0]] += item[1];
        
        for (int[] item : items2)
            weights[item[0]] += item[1];
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (weights[i] != 0) {
                List<Integer> valueWeights = new ArrayList<>();
                valueWeights.add(i);
                valueWeights.add(weights[i]);
                res.add(valueWeights);
            }
        }
        return res;
    }
}
