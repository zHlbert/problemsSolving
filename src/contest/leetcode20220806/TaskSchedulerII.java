package contest.leetcode20220806;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {
    /**
     * 贪心
     * @param tasks
     * @param space
     * @return
     */
    public long taskSchedulerII(int[] tasks, int space) {
        long res = 0;
        Map<Integer, Long> taskDays = new HashMap<>();
        for (int type : tasks) {
            res++;
            if (taskDays.containsKey(type)) {
                Long last = taskDays.get(type);
                res += Math.max(0, space - res + last + 1);
            }
            taskDays.put(type, res);
        }
        return res;
    }

    public static void main(String[] args) {
        TaskSchedulerII ts = new TaskSchedulerII();
//        int[] tasks = new int[] {1,2,1,2,3,1};
//        int space = 3;
        int[] tasks = new int[] {5,8,8,5};
        int space = 2;
        System.out.println(ts.taskSchedulerII(tasks, space));
    }
}
