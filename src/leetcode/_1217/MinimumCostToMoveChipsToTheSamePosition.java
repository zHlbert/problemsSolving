package leetcode._1217;

import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int p : position) {
            int cnt = cntMap.getOrDefault(p, 0);
            cntMap.put(p, cnt + 1);
        }

        long minCost = Integer.MAX_VALUE;
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(cntMap.entrySet());
        int size = entries.size();
        for (Map.Entry<Integer, Integer> entry0 : entries) {
            long cost = 0;
            int j = 0;
            for (; j < size && cost < minCost; j++) {
                Map.Entry<Integer, Integer> entry1 = entries.get(j);
                cost += (long) (Math.abs(entry1.getKey() - entry0.getKey()) & 1) * entry1.getValue();
            }
            if (j == size) {
                minCost = Math.min(minCost, cost);
            }
        }
        return (int) minCost;
    }

    public static void main(String[] args) {
        MinimumCostToMoveChipsToTheSamePosition mc = new MinimumCostToMoveChipsToTheSamePosition();
//        int[] position = new int[] {1,2,3};
//        int[] position = new int[] {1,1000000000};
        int[] position = new int[] {2,2,2,3,3};
        System.out.println(mc.minCostToMoveChips1(position));
    }

    public int minCostToMoveChips1(int[] position) {
        int[] cnts = new int[2];
        for (int p : position) {
            cnts[p & 1]++;
        }
        return Math.min(cnts[0], cnts[1]);
    }
}
