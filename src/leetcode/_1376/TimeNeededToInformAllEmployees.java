package leetcode._1376;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (i != headID)
                tree[manager[i]].add(i);
        }
        int res = 0;
        int[] time = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(headID);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == headID) time[node] = 0;
            else {
                time[node] = time[manager[node]] + informTime[manager[node]];
                res = Math.max(res, time[node]);
            }
            for (int sub : tree[node]) {
                q.offer(sub);
            }
        }
        return res;
    }

//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        int[] time = new int[n];
//        int res = 0;
//
//    }
}
