package contest.leetcode20220417;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int task : tasks) {
            Integer currFreq = freqMap.getOrDefault(task, 0);
            freqMap.put(task, currFreq + 1);
        }
        int res = 0;
        for (Integer value : freqMap.values()) {
            if (value == 1) {
                return -1;
            }
            res += (value - 1) / 3 + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumRoundsToCompleteAllTasks m = new MinimumRoundsToCompleteAllTasks();
        int[] tasks = new int[] {2,3,3};
//        int[] tasks = new int[] {2,2,3,3,2,4,4,4,4,4};
        System.out.println(m.minimumRounds(tasks));
    }
}
