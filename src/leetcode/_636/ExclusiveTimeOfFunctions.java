package leetcode._636;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/exclusive-time-of-functions/
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> stack = new ArrayDeque<int[]>();
        for (String log : logs) {
            String[] params = log.split(":");
            int id = Integer.parseInt(params[0]), se = "start".equals(params[1]) ? 0 : 1, ts = Integer.parseInt(params[2]);
            if (se == 1) {
                int[] last = stack.pop();
                res[id] += (ts - last[1] + 1);
                if (!stack.isEmpty()) {
                    stack.peek()[1] = ts + 1;
                }
            } else {
                if (!stack.isEmpty()) {
                    int[] last = stack.peek();
                    res[last[0]] += ts - last[1];
                }
                stack.push(new int[] {id, ts});
            }
        }
        return res;
    }
}
