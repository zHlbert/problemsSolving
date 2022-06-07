package leetcode._621;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/task-scheduler/
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        Arrays.sort(cnt);
        // [j + 1, 25] 表示出现次数最多的任务
        int j = 24;
        while (j >= 0 && cnt[j] == cnt[25]) {
            j--;
        }
        // 如果间隔n足够插入 除次数最多任务以外 的所有任务，则最大长度为右式，否则若间隔不够插入，则总时间为任务长度
        return Math.max(tasks.length, (n + 1) * (cnt[25] - 1) + 25 - j);
    }

    public int leastInterval1(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }

        int maxC = 0;
        for (int i = 0; i < 26; i++) {
            maxC = Math.max(maxC, cnt[i]);
        }

        int notFullCnt = (n + 1) * (maxC - 1);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == maxC) {
                notFullCnt++;
            }
        }
        return Math.max(tasks.length, notFullCnt);
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        char[] tasks = new char[] {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(ts.leastInterval(tasks, n));
    }
}
