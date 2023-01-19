package leetcode._1817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {
    /**
     * 哈希
     * @param logs
     * @param k
     * @return
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> idMin = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> times = idMin.getOrDefault(log[0], new HashSet<>());
            times.add(log[1]);
            idMin.put(log[0], times);
        }

        int[] res = new int[k];
        for (Set<Integer> mins : idMin.values()) {
            res[mins.size() - 1]++;
        }
        return res;
    }
}
